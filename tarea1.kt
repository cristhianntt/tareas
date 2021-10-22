package com.example.tarea2

fun main() {
    //TODO: Crear una función de de extensión que extienda de una Lista que retorne el promedio de los elementos.
    //Para sacar el promedio se debe seguir las siguientes condiciones:
    //a) Se debe eliminar la nota mas baja.
    //b) Se debe duplicar la nota mas alta.
    //c) Puede haber "errores del sistema" por esa razón tiene que validar que la nota este en el rango de 0 a 20.
    //d) Si la nota ingresada es mayor a 20 considerar el valor máximo posible, si es menor a 0 considerar el valor mínimo.
    val notes = listOf(13,22,"18",15,"11",-4,16)
    val notesCopy = mutableListOf<Int>()

    for ((index, item) in notes.withIndex()){
        var nota = if(item is String) item.toInt() 	else if(item is Int) item 	else 0		//cuando if retorna, debe estar presente "else"

        nota = normalizarNota(nota)
        notesCopy.add(nota)
    }

    val notesFinal = eliminarMinMax(notesCopy)
    println(notesFinal)
    print("La nota es: ${notesFinal.promedio()}")
}

fun normalizarNota(nota: Int): Int{
    var notaNormalizada = nota

    try{
        if(nota !in 0..20)	throw Exception("no está en el rango")
    }catch(e: Exception){
        notaNormalizada = if (nota < 0) 0	else 20
    }

    return notaNormalizada
}

fun eliminarMinMax(lista: MutableList<Int>): MutableList<Int>{
    val comparator = Comparator { item1: Int, item2: Int -> item1 - item2 }

    val minimo = lista.sortedWith(comparator)[0]
    val maximo = lista.sortedWith(comparator)[lista.size-1]
    lista.remove(minimo)
    lista.add(maximo)

    return lista
}

fun List<Int>.promedio(): Double = this.average()
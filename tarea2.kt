package com.example.tarea2

fun main() {

    //TODO: El ejercicio de hoy es crear dos clases (Dog, Cat) que extiendan de la clase Pet
    //1. Implementar las funciones de la interface PetAction en cada clase (Imaginación)
    //2. Para la función adopt() asignar el nombre de la mascota
    //3. Ejecutar el código

    val pet = Dog("Shiba", Gender.MALE)
    pet.adopt("Niño")

    println(pet.name)
    println(pet.sound())

    val pet2 = Cat("Siamés", Gender.FEMALE)
    pet2.adopt("Nala")

    println(pet2.name)
    println(pet2.sound())
    //pet2.eat()
}

class Dog(breed: String, gender: Gender): Pet(breed, gender) {

    override fun eat() {
        println("$name está comiendo .. no molestar!")
    }

    override fun sound(): String = "$name está ladrando"

    override fun adopt(newName: String) {
        name = newName
    }

}


class Cat(breed: String, gender: Gender): Pet(breed, gender) {

    override fun eat() {
        println("Cuidado!! .. $name está comiendo")
    }

    override fun sound(): String = "$name está maullando"

    override fun adopt(newName: String) {
        name = newName
    }

}


interface PetAction {
    fun eat()
    fun sound(): String = ""
    fun adopt(newName: String)
}

enum class Gender {
    MALE, FEMALE
}

abstract class Pet(open val breed: String, open val gender: Gender) : PetAction {

    open lateinit var name: String

}
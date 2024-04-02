//Zeynep Rana Uyar
//180101053
import java.util.*

open class Item(val name:String,val price:Double)

class Food(name:String,price:Double,val weight:String) :Item(name,price)

class Cloth(name:String,price:Double,val type:String) : Item(name,price)

class ShoppingList{
    private val items = mutableListOf<Item>()

    fun addItem(item:Item) {
        items.add(item)
        println("${item.name} added successfully!")
    }

    fun displayItems(){
        println("Your shopping list :")
        for ((index, item) in items.withIndex()) {
            println("${index + 1}. ${item.name}, Price: ${item.price}")
            when (item) {
                is Food -> println("   Weight: ${item.weight}")
                is Cloth -> println("   Type: ${item.type}")
            }
        }
    }

    fun deleteItem(index: Int) {
        if (index in 1..items.size) {
            val deletedItem = items.removeAt(index - 1)
            println("${deletedItem.name} deleted successfully!")
        }
    }


    fun main(args: Array<String>) {

        val scanner = Scanner(System.`in`)
        val shoppingList = ShoppingList()

        while (true) {
            println("\nMenu:")
            println("1) Add Item")
            println("2) Display Item")
            println("3) Delete Item")
            println("4) Exit")

            print("Make your choice: ")

            when (scanner.nextInt()) {
                1 -> {
                    println("Select type of item:")
                    println("1: Food")
                    println("2: Cloth")
                    print("Enter your choice: ")
                    val typeChoice = scanner.nextInt()
                    when (typeChoice) {
                        1 -> {
                            print("Enter food name: ")
                            val name = scanner.next()
                            print("Enter price: ")
                            val price = scanner.nextDouble()
                            print("Enter weight: ")
                            val weight = scanner.next()
                            shoppingList.addItem(Food(name, price, weight))
                        }

                        2 -> {
                            print("Enter cloth name: ")
                            val name = scanner.next()
                            print("Enter price: ")
                            val price = scanner.nextDouble()
                            print("Enter type: ")
                            val type = scanner.next()
                            shoppingList.addItem(Cloth(name, price, type))
                        }

                        else -> println("Invalid choice.")
                    }
                }

                2 -> shoppingList.displayItems()

                3 -> {
                    println("Enter the number of item to delete:")
                    val index = scanner.nextInt()
                    shoppingList.deleteItem(index)
                }

                4 -> {
                    println("Exiting...")
                    return
                }

                else -> println("Invalid choice.")
            }


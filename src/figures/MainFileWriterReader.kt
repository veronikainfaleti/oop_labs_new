package figures

fun main() {

    //make triangle
    val triangle = Triangle(
            3.0,
            4.0,
            5.0
    )

    //make circles
    val circle = Circle(2.0)

    //make square
    val square = Square(10.0)

    //make rectangles
    val rectangle = Rectangle(10.0, 20.0)

    val list = listOf(
            triangle,
            circle,
            square,
            rectangle
    )


    //filename
    val filename = "shapes.bin"

    //get writer/reader for file
    val fileWriter = FileWriter()
    //try to write the list to file
    try {
        fileWriter.write(list, filename)
    } catch (e: FileSystemException) {
        e.printStackTrace()
    }

    //try to read the list from file
    /*result: [Triangle(3.0,4.0,5.0), Circle(2.0), Square(10.0), Rectangle(10.0,20.0)]
    * */
    try {
        val listFromFile = fileWriter.read(filename) as List<*>
        println(listFromFile)
    } catch (e: FileSystemException) {
        e.printStackTrace()
    } catch (e: NoSuchElementException) {
        e.printStackTrace()
    } catch (e: TypeCastException) {
        e.printStackTrace()
    }
}
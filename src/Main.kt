fun main() {
    try {

        val tiempoFijo = Tiempo(20,15,20)

        println("Introduce la hora a incrementar: ")
        val hora = readln().toInt()

        println("Introduce los minutos a incrementar: ")
        val minuto = readln().toInt()

        println("Introduce los segundos a incrementar: ")
        val segundo = readln().toInt()

        val tiempoAIncrementar = Tiempo(hora,minuto,segundo)

        println("El tiempo es $tiempoFijo")

        if (tiempoFijo.incrementar(tiempoAIncrementar)) {
            println("Tiempo incrementado: $tiempoFijo")
        } else {
            throw IndexOutOfBoundsException("*** ERROR *** - El tiempo sobrepasa el limite maximo")
        }

        println("Introduce la hora a decrementar: ")
        val hora1 = readln().toInt()

        println("Introduce los minutos a decrementar: ")
        val minuto1 = readln().toInt()

        println("Introduce los segundos a decrementar: ")
        val segundo1 = readln().toInt()

        val tiempoADecrementar = Tiempo(hora1,minuto1,segundo1)

        println("El tiempo es $tiempoFijo")

        if (tiempoFijo.decrementar(tiempoADecrementar)) {
            println("El tiempo decrementado es: $tiempoFijo")
        } else {
            throw IndexOutOfBoundsException("*** ERROR *** - El tiempo es menor al limite minimo")
        }

    } catch (e: IllegalArgumentException) {
        println(e.message)
    } catch (e: IndexOutOfBoundsException) {
        println(e.message)
    }
}
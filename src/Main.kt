fun main() {
    try {

        val tiempoFijo = Tiempo(20,15,20)

        //INCREMENTO
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

        //DECREMENTO
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

        //COMPARACION
        println("Introduce la hora a comparar: ")
        val hora2 = readln().toInt()

        println("Introduce los minutos a comparar: ")
        val minuto2 = readln().toInt()

        println("Introduce los segundos a comparar: ")
        val segundo2 = readln().toInt()

        val tiempoComparar = Tiempo(hora2,minuto2,segundo2)

        val comparacion = tiempoFijo.comparar(tiempoComparar)

        when (comparacion) {
            -1 -> println("$tiempoComparar es menor que $tiempoFijo")
            0 -> println("$tiempoComparar es igual que $tiempoFijo")
            1 -> println("$tiempoComparar es menor que $tiempoFijo")
        }

        //COPIA
        println("COPIA: ${tiempoFijo.copiar()}")

        //COPIA 2
        println("COPIA 2: ${tiempoFijo.copiar(tiempoComparar)}")

        //SUMA
        println("Introduce la hora a sumar: ")
        val hora3 = readln().toInt()

        println("Introduce los minutos a sumar: ")
        val minuto3 = readln().toInt()

        println("Introduce los segundos a sumar: ")
        val segundo3 = readln().toInt()

        val tiempoSumar = Tiempo(hora3,minuto3,segundo3)

        val tiempoTotal = tiempoFijo.sumar(tiempoSumar)

        if (tiempoTotal == null) {
            throw IndexOutOfBoundsException("La hora sobrepasa el limite maximo (23:59:59)")
        } else {
            println("El resultado es $tiempoTotal")
        }

        //RESTA
        println("Introduce la hora a restar: ")
        val hora4 = readln().toInt()

        println("Introduce los minutos a restar: ")
        val minuto4 = readln().toInt()

        println("Introduce los segundos a restar: ")
        val segundo4 = readln().toInt()

        val tiempoRestar = Tiempo(hora4,minuto4,segundo4)

        val tiempoTotal2 = tiempoFijo.resta(tiempoRestar)

        if (tiempoTotal2 == null) {
            throw IndexOutOfBoundsException("La hora es menor el limite minimo (00:00:00)")
        } else {
            println("El resultado de restar $tiempoFijo - $tiempoRestar es $tiempoTotal2")
        }

        //MAYOR QUE O MENOR QUE
        println("Introduce la hora para comparar si es mayor o menor: ")
        val hora5 = readln().toInt()

        println("Introduce los minutos para comparar si es mayor o menor: ")
        val minuto5 = readln().toInt()

        println("Introduce los segundos para comparar si es mayor o menor: ")
        val segundo5 = readln().toInt()

        val tiempoComparar1 = Tiempo(hora5,minuto5,segundo5)

        if (tiempoFijo.esMayorQue(tiempoComparar1)) {
            println("$tiempoFijo es mayor que $tiempoComparar1")
        } else if (tiempoFijo.esMenorQue(tiempoComparar1)) {
            println("$tiempoFijo es menor que $tiempoComparar1")
        } else {
            println("$tiempoFijo es igual que $tiempoComparar1")
        }
    } catch (e: IllegalArgumentException) {
        println(e.message)
    } catch (e: IndexOutOfBoundsException) {
        println(e.message)
    }
}
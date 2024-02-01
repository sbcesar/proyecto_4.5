fun main() {

    val tiempoFijo = Tiempo(20, 15, 20)

    while (true) {
        println("\nMenu:")
        println("1. Incrementar")
        println("2. Decrementar")
        println("3. Comparar")
        println("4. Copiar")
        println("5. Copiar 2")
        println("6. Sumar")
        println("7. Restar")
        println("8. Mayor que/Menor que")
        println("9. Salir")
        print("Seleccione una opción: ")

        try {
            when (readlnOrNull()?.toInt()) {
                1 -> {
                    println("Introduce la hora a incrementar: ")
                    val hora = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los minutos a incrementar: ")
                    val minuto = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los segundos a incrementar: ")
                    val segundo = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    val tiempoAIncrementar = Tiempo(hora, minuto, segundo)
                    if (tiempoFijo.incrementar(tiempoAIncrementar)) {
                        println("Tiempo incrementado: $tiempoFijo")
                    } else {
                        throw IndexOutOfBoundsException("*** ERROR *** - El tiempo sobrepasa el limite maximo")
                    }
                }
                2 -> {
                    println("Introduce la hora a decrementar: ")
                    val hora = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los minutos a decrementar: ")
                    val minuto = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los segundos a decrementar: ")
                    val segundo = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    val tiempoADecrementar = Tiempo(hora, minuto, segundo)
                    if (tiempoFijo.decrementar(tiempoADecrementar)) {
                        println("Tiempo decrementado: $tiempoFijo")
                    } else {
                        throw IndexOutOfBoundsException("*** ERROR *** - El tiempo es menor al limite minimo")
                    }
                }
                3 -> {
                    println("Introduce la hora a comparar: ")
                    val hora = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los minutos a comparar: ")
                    val minuto = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los segundos a comparar: ")
                    val segundo = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    val tiempoComparar = Tiempo(hora, minuto, segundo)
                    val comparacion = tiempoFijo.comparar(tiempoComparar)
                    when (comparacion) {
                        -1 -> println("$tiempoComparar es menor que $tiempoFijo")
                        0 -> println("$tiempoComparar es igual que $tiempoFijo")
                        1 -> println("$tiempoComparar es mayor que $tiempoFijo")
                    }
                }
                4 -> println("Copia: ${tiempoFijo.copiar()}")
                5 -> {
                    println("Introduce la hora a copiar: ")
                    val hora = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los minutos a copiar: ")
                    val minuto = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los segundos a copiar: ")
                    val segundo = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    val tiempoACopiar = Tiempo(hora, minuto, segundo)
                    println("Copia 2: ${tiempoFijo.copiar(tiempoACopiar)}")
                }
                6 -> {
                    println("Introduce la hora a sumar: ")
                    val hora = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los minutos a sumar: ")
                    val minuto = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los segundos a sumar: ")
                    val segundo = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    val tiempoASumar = Tiempo(hora, minuto, segundo)
                    val resultadoSuma = tiempoFijo.sumar(tiempoASumar)
                    if (resultadoSuma != null) {
                        println("Resultado de la suma: $resultadoSuma")
                    } else {
                        throw IndexOutOfBoundsException("La suma supera 23:59:59")
                    }
                }
                7 -> {
                    println("Introduce la hora a restar: ")
                    val hora = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los minutos a restar: ")
                    val minuto = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los segundos a restar: ")
                    val segundo = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    val tiempoARestar = Tiempo(hora, minuto, segundo)
                    val resultadoResta = tiempoFijo.restar(tiempoARestar)
                    if (resultadoResta != null) {
                        println("Resultado de la resta: $resultadoResta")
                    } else {
                        throw IndexOutOfBoundsException("La resta es menor que 00:00:00")
                    }
                }
                8 -> {
                    println("Introduce la hora para comparar si es mayor o menor: ")
                    val hora = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los minutos para comparar si es mayor o menor: ")
                    val minuto = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    println("Introduce los segundos para comparar si es mayor o menor: ")
                    val segundo = readlnOrNull()?.toInt() ?: throw NumberFormatException()
                    val tiempoComparar = Tiempo(hora, minuto, segundo)
                    if (tiempoFijo.esMayorQue(tiempoComparar)) {
                        println("$tiempoFijo es mayor que $tiempoComparar")
                    } else if (tiempoFijo.esMenorQue(tiempoComparar)) {
                        println("$tiempoFijo es menor que $tiempoComparar")
                    } else {
                        println("$tiempoFijo es igual que $tiempoComparar")
                    }
                }
                9 -> return
                else -> println("Opción inválida")
            }
        } catch (e: NumberFormatException) {
            println("¡Error! Introduce un número válido.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        } catch (e: IndexOutOfBoundsException) {
            println(e.message)
        }
    }
}
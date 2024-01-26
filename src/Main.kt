fun main() {

    println("Introduce la hora: ")
    val hora = readln().toIntOrNull() ?: 0

    println("Introduce los minutos: ")
    val minuto = readln().toIntOrNull() ?: 0

    println("Introduce los segundos: ")
    val segundo = readln().toIntOrNull() ?: 0

    val tiempo1 = Tiempo(hora,minuto,segundo)

    println("La hora es: $tiempo1")

}
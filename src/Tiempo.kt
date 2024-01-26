class Tiempo(private var horas: Int, private var minutos: Int, private var segundos: Int) {

    init {
        require(horas in 0..23) { "La hora debe estar desde 0 a 23" }
        require(minutos in 0..59) { "Los minutos deben estar desde 0 a 59" }
        require(segundos in 0..59) { "Los segundos deben estar desde 0 a 59" }

        val minutosAjustados = (minutos + segundos / 60) % 60
        val horasAjustadas = (horas + minutos / 60) % 24

        this.horas = horasAjustadas
        this.minutos = minutosAjustados
        this.segundos %= 60
    }

    override fun toString(): String {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos)
    }

}
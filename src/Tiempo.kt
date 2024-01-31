class Tiempo(private var horas: Int, private var minutos: Int, private var segundos: Int) {

    init {
        require(horas in 0..23) { "La hora debe estar desde 0 a 23" }

        if (minutos > 60 || segundos > 60) {
            val minutosAjustados = (minutos + segundos / 60) % 60
            val horasAjustadas = (horas + minutos / 60) % 24

            this.horas = horasAjustadas
            this.minutos = minutosAjustados
            this.segundos %= 60
        }
    }

    constructor(horas: Int) : this(horas,0,0) {
        this.horas = horas
    }

    constructor(horas: Int,minutos: Int) : this(horas,minutos,0) {
        this.horas = horas
        this.minutos = minutos
    }

    fun incrementar(t:Tiempo): Boolean {
        segundos += t.segundos
        minutos += t.minutos
        horas += t.horas

        if (segundos >= 60 || minutos >= 60 || horas >= 24) {
            minutos += segundos / 60
            horas += minutos / 60

            segundos %= 60
            minutos %= 60
            horas %= 24

            return false
        }

        return true
    }

    fun decrementar(t: Tiempo): Boolean {
        segundos -= t.segundos
        minutos -= t.minutos
        horas -= t.horas

        if (segundos < 0 || minutos < 0 || horas < 0) {
            minutos -= (segundos / 60 + 1)
            horas -= (minutos / 60 + 1)

            segundos = 60 + (segundos % 60)
            minutos = 60 + (minutos % 60)
            horas = 24 + (horas % 24)

            return false
        }

        return true
    }


    override fun toString(): String {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos)
    }

}
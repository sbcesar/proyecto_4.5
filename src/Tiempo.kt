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

    fun comparar(t:Tiempo): Int {
        return if (t.horas < horas && t.minutos < minutos && t.segundos < segundos) {
            -1
        } else if (t.horas > horas && t.minutos > minutos && t.segundos > segundos) {
            1
        } else {
            0
        }
    }

    //Esta funcion es util si deseas hacer calculos con el objeto sin modificar el original
    fun copiar(): Tiempo {
        return Tiempo(horas,minutos,segundos)
    }

    //Esta funcion es util si quiero actualizar los valores del objeto con otro objeto, al haber otra funcion copiar esto se le denomina saturacion
    fun copiar(t: Tiempo): Tiempo {
        this.horas = t.horas
        this.minutos = t.minutos
        this.segundos = t.segundos
        return this
    }

    fun sumar(t:Tiempo): Tiempo? {
        val sumaSegundos = this.segundos + t.segundos
        val sumaMinutos = this.minutos + t.minutos + sumaSegundos / 60
        val sumaHoras = this.horas + t.horas + sumaMinutos / 60

        val segundosResultado = sumaSegundos % 60
        val minutosResultado = sumaMinutos % 60
        val horasResultado = sumaHoras % 24

        if (sumaHoras >= 24) {
            return null
        }

        return Tiempo(horasResultado, minutosResultado, segundosResultado)
    }

    fun resta(t:Tiempo): Tiempo? {
        val restaSegundos = this.segundos - t.segundos
        var restaMinutos = this.minutos - t.minutos
        var restaHoras = this.horas - t.horas

        if (restaSegundos < 0) {
            restaMinutos -= 1
        }
        if (restaMinutos < 0) {
            restaHoras -= 1
        }

        if (restaHoras < 0) {
            return null
        }

        val segundosResultado = if (restaSegundos < 0) 60 + restaSegundos else restaSegundos
        val minutosResultado = if (restaMinutos < 0) 60 + restaMinutos else restaMinutos
        val horasResultado = if (restaHoras < 0) 24 + restaHoras else restaHoras

        return Tiempo(horasResultado, minutosResultado, segundosResultado)
    }

    fun esMayorQue(t: Tiempo): Boolean {
        return comparar(t) == 1
    }

    fun esMenorQue(t: Tiempo): Boolean {
        return comparar(t) == -1
    }

    override fun toString(): String {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos)
    }

}
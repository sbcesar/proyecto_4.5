/**
 * Clase que representa un tiempo en horas, minutos y segundos.
 * @property horas Las horas del tiempo.
 * @property minutos Los minutos del tiempo.
 * @property segundos Los segundos del tiempo.
 * @constructor Crea un objeto Tiempo con las horas, minutos y segundos especificados.
 */
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

    /**
     * Constructor secundario que crea un objeto Tiempo con las horas especificadas y los minutos y segundos por defecto (0).
     * @param horas Las horas del tiempo.
     */
    constructor(horas: Int) : this(horas,0,0) {
        this.horas = horas
    }

    /**
     * Constructor secundario que crea un objeto Tiempo con las horas y minutos especificados, y los segundos por defecto (0).
     * @param horas Las horas del tiempo.
     * @param minutos Los minutos del tiempo.
     */
    constructor(horas: Int,minutos: Int) : this(horas,minutos,0) {
        this.horas = horas
        this.minutos = minutos
    }

    /**
     * Incrementa el tiempo actual sumando el tiempo especificado.
     * @param t El tiempo a sumar.
     * @return true si el tiempo se incrementa con éxito, false si el resultado supera los límites permitidos.
     */
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

    /**
     * Decrementa el tiempo actual restando el tiempo especificado.
     * @param t El tiempo a restar.
     * @return true si el tiempo se decrementa con éxito, false si el resultado es menor que 00:00:00.
     */
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

    /**
     * Compara este tiempo con otro tiempo especificado.
     * @param t El tiempo con el que comparar.
     * @return -1 si este tiempo es menor que el tiempo especificado, 0 si son iguales, 1 si este tiempo es mayor.
     */
    fun comparar(t:Tiempo): Int {
        return if (t.horas < horas && t.minutos < minutos && t.segundos < segundos) {
            -1
        } else if (t.horas > horas && t.minutos > minutos && t.segundos > segundos) {
            1
        } else {
            0
        }
    }

    /**
     * Realiza una copia de este tiempo.
     * Esta funcion es util si deseas hacer calculos con el objeto sin modificar el original
     * @return Una copia de este tiempo.
     */
    fun copiar(): Tiempo {
        return Tiempo(horas,minutos,segundos)
    }

    /**
     * Copia el tiempo especificado en este tiempo.
     * Esta funcion es util si quiero actualizar los valores del objeto con otro objeto, al haber otra funcion copiar esto se le denomina saturacion
     * @param t El tiempo a copiar.
     * @return Este objeto Tiempo con los valores copiados.
     */
    fun copiar(t: Tiempo): Tiempo {
        this.horas = t.horas
        this.minutos = t.minutos
        this.segundos = t.segundos
        return this
    }

    /**
     * Suma el tiempo especificado a este tiempo.
     * @param t El tiempo a sumar.
     * @return El resultado de la suma como un nuevo objeto Tiempo, o null si el resultado supera 23:59:59.
     */
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

    /**
     * Resta el tiempo especificado de este tiempo.
     * @param t El tiempo a restar.
     * @return El resultado de la resta como un nuevo objeto Tiempo, o null si el resultado es menor que 00:00:00.
     */
    fun restar(t:Tiempo): Tiempo? {
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

    /**
     * Comprueba si este tiempo es mayor que el tiempo especificado.
     * @param t El tiempo con el que comparar.
     * @return true si este tiempo es mayor que el tiempo especificado, false en caso contrario.
     */
    fun esMayorQue(t: Tiempo): Boolean {
        return comparar(t) == 1
    }

    /**
     * Comprueba si este tiempo es menor que el tiempo especificado.
     * @param t El tiempo con el que comparar.
     * @return true si este tiempo es menor que el tiempo especificado, false en caso contrario.
     */
    fun esMenorQue(t: Tiempo): Boolean {
        return comparar(t) == -1
    }

    /**
     * Devuelve una representación en formato de cadena de este tiempo en el formato HH:MM:SS.
     * @return El tiempo en formato de cadena.
     */
    override fun toString(): String {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos)
    }
}
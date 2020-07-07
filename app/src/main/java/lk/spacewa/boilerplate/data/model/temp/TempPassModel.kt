package lk.spacewa.boilerplate.data.model.temp

/**
 * Created by Imdad on 5/22/2020.
 */
class TempPassModel(passID: String?, name: String?) {
    var passID: String? = null
    var name: String? = null

    init {
        this.name = name
        this.passID = passID
    }
}
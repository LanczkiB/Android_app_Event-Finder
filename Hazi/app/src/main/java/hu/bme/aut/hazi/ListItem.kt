package hu.bme.aut.hazi

data class ListItem(
    var id: Long?,
    var name: String,
    var description: String,
    var picture: Int,
    var type: Int,
    var date: String,
    var parti: String
)
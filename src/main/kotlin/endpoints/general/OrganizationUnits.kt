package endpoints.general

import io.ktor.resources.Resource
import kotlinx.serialization.Serializable

@Serializable
@Resource("organization-units")
class OrganizationUnitsRq {
    @Serializable
    @Resource("{number}")
    class Number(val parent: OrganizationUnitsRq = OrganizationUnitsRq(), val number: String) {
        @Serializable
        @Resource("present-persons")
        class PresentPersons(val parent: Number)
    }
}

@Serializable
data class OrganizationUnitList(
    val organizationUnits: List<OrganizationUnit>,
)

@Serializable
data class OrganizationUnit(
    val number: String,
    val name: String,
    val additionalName: String = "",
    val sapCodeType: String = "",
    val sapUnitCode: String = "",
    val countryCode: String,
    val parentOrganizationUnit: OrganizationUnit? = null,
)

@Serializable
data class PersonsList(
    val persons: List<Person>,
)

@Serializable
data class Person(
    val personnelNumber: String,
    val personId: String,
    val firstName: String,
    val lastName: String,
)
package uz.blog.leads.data.mapper

import uz.blog.LeadItemQuery
import uz.blog.LeadsItemsQuery
import uz.blog.leads.model.LeadDetail
import uz.blog.leads.model.LeadsItems

fun LeadsItemsQuery.AllPeople.toAllPeopleList(): List<LeadsItems> =
    this.people
        ?.mapNotNull {result->
            LeadsItems(
                id = result?.id.orEmpty(),
                name = result?.name.orEmpty(),
                lastName = result?.name.orEmpty(),
                imageRes = "",
                countryFlag = 0,
                status = "New"
            )
        }.orEmpty()

fun LeadItemQuery.Person.toPerson(): LeadDetail =
    LeadDetail(
        id = this.id.orEmpty(),
        name = this.name.orEmpty(),
        birthYear = this.birthYear.orEmpty(),
        gender = this.gender.orEmpty()
    )
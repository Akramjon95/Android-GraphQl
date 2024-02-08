package uz.blog.leads.data.network

import com.apollographql.apollo3.ApolloClient
import uz.blog.LeadItemQuery
import uz.blog.LeadsItemsQuery
import uz.blog.leads.data.mapper.toAllPeopleList
import uz.blog.leads.data.mapper.toPerson
import uz.blog.leads.model.LeadDetail
import uz.blog.leads.model.LeadsItems
import uz.blog.leads.network.GraphqlClient

class ApolloGraphqlClint(private val apolloClint: ApolloClient): GraphqlClient {
    override suspend fun getLeads(): List<LeadsItems> =
        apolloClint
            .query(LeadsItemsQuery())
            .execute()
            .data
            ?.allPeople
            ?.toAllPeopleList()
            .orEmpty()

    override suspend fun getLeadById(id: String): LeadDetail? =
        apolloClint
            .query(LeadItemQuery(id))
            .execute()
            .data
            ?.person
            ?.toPerson()


}
package uz.blog.leads.data.network

import uz.blog.leads.model.LeadsItems
import uz.blog.leads.network.GraphqlClient

class ApolloClint: GraphqlClient {
    override suspend fun getLeads(): List<LeadsItems> {
        TODO("Not yet implemented")
    }

    override suspend fun getLeadById(id: String): LeadsItems? {
        TODO("Not yet implemented")
    }

}
package uz.blog.leads.network

import uz.blog.leads.model.LeadsItems

interface GraphqlClient {
    suspend fun getLeads(): List<LeadsItems>

    suspend fun getLeadById(id: String): LeadsItems?
}
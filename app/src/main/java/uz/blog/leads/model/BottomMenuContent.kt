package uz.blog.leads.model

import androidx.annotation.DrawableRes
import uz.blog.leads.R
import uz.blog.leads.navgraph.NavPath
import uz.blog.leads.navgraph.NavTitle

sealed class BottomMenuContent(
    val route: String,
    val title: String,
    @DrawableRes val iconId: Int
){
    object Home: BottomMenuContent(
        route = NavPath.HOME.toString(),
        title = NavTitle.HOME,
        iconId =  R.drawable.home
    )
    object Calls: BottomMenuContent(
        route = NavPath.CALLS.toString(),
        title = NavTitle.CALLS,
        iconId =  R.drawable.phone
    )
    object Chats: BottomMenuContent(
        route = NavPath.CHAT.toString(),
        title = NavTitle.CHAT,
        iconId =  R.drawable.chat
    )
    object Leads: BottomMenuContent(
        route = NavPath.LEADS.toString(),
        title = NavTitle.LEADS,
        iconId =  R.drawable.profile
    )

    object More: BottomMenuContent(
        route = NavPath.MORE.toString(),
        title = NavTitle.MORE,
        iconId =  R.drawable.menu
    )
}

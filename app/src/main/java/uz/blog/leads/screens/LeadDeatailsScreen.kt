package uz.blog.leads.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.blog.leads.R
import uz.blog.leads.ui.theme.BoxBgColor
import uz.blog.leads.ui.theme.PurpleGrey40
import uz.blog.leads.ui.theme.borderBg
import uz.blog.leads.ui.theme.saveBtnColor
import uz.blog.leads.ui.theme.textViewBg

@Preview
@Composable
fun LeadDetailsScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
    ) {
        ToolbarDetails()
        ProfileUI()
        GeneralOptionsUI()

        SaveItemsViewDT()
    }
}

@Composable
fun SaveItemsViewDT(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(130.dp)
        .padding(16.dp)
        .clip(RoundedCornerShape(20.dp))
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .border(1.dp, color = saveBtnColor)
                    .padding(12.dp),
                onClick = { }
            ) {
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(painter = painterResource(id = R.drawable.chat_icon),
                        contentDescription = "chat",
                        Modifier.size(20.dp))
                    Text(
                        text = "Chat",
                        fontSize = 16.sp,
                        color = saveBtnColor
                    )
                }

            }
            Spacer(modifier = Modifier.width(15.dp))
            Button(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(saveBtnColor)
                    .padding(12.dp),
                onClick = { }
            ) {
                Text(text = "Call", fontSize = 16.sp, color = Color.Black)
            }
        }

    }
}

@Composable
fun ToolbarDetails(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Box(modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(BoxBgColor)
            .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_btn),
                contentDescription = "Add",
                modifier = Modifier.size(26.dp)
            )
        }
        Text(text = "Lead details", fontSize = 24.sp,)
//        Box(modifier = Modifier
//            .fillMaxWidth(),
//            contentAlignment = Alignment.Center
//        ) {
//
//        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box(modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(BoxBgColor)
                .padding(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.refresh),
                    contentDescription = "Refresh",
                    modifier = Modifier.size(26.dp)
                )
            }

            Box(modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(BoxBgColor)
                .padding(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "Edit",
                    modifier = Modifier.size(26.dp)
                )
            }
        }


    }

}

@Composable
fun ProfileUI(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(
            top = 40.dp,
            bottom = 10.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.refresh),
            contentDescription = "Profile",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Akramjon Kuchkarov",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = "ID: 234234",
            fontSize = 12.sp
        )

        profileItems()
    }
}

@Composable
fun profileItems(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(8.dp)
                ) {

                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Lead status",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        modifier = Modifier.padding(end = 5.dp),
                        text = "Option sent",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                StepsProgressBarPreview()
            }
        }

        Card(
            modifier = Modifier
                .padding(vertical = 15.dp)
                .fillMaxWidth()
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(8.dp)
                ) {

                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Lead quality",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        modifier = Modifier.padding(end = 5.dp),
                        text = "35 %",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                LinerProgressBar()
            }
        }
    }
}

@Composable
fun StepsProgressBar(modifier: Modifier = Modifier, numberOfSteps: Int, currentStep: Int) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (step in 0..numberOfSteps) {
            Step(
                modifier = Modifier.weight(1F),
                isCompete = step < currentStep,
                isCurrent = step == currentStep
            )
        }
    }
}

@Composable
fun Step(modifier: Modifier = Modifier, isCompete: Boolean, isCurrent: Boolean) {
    val color = if (isCompete || isCurrent) saveBtnColor else Color.LightGray
    val innerCircleColor = if (isCompete) saveBtnColor else Color.LightGray

    Box(modifier = modifier) {

        //Line
        Divider(
            modifier = Modifier.align(Alignment.CenterStart),
            color = color,
            thickness = 2.dp
        )

        //Circle
        Canvas(modifier = Modifier
            .size(20.dp)
            .align(Alignment.CenterEnd)
            .clip(RoundedCornerShape(6.dp))
            ,
            onDraw = {
                drawCircle(color = innerCircleColor)
            }
        )
    }
}


@Composable
fun StepsProgressBarPreview() {
    val currentStep = remember { mutableStateOf(1) }
    StepsProgressBar(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 5.dp, top = 4.dp, bottom = 8.dp, end = 5.dp)
        .clip(RoundedCornerShape(10.dp)),
        numberOfSteps = 5, currentStep = currentStep.value)
}

@Composable
fun LinerProgressBar(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, top = 4.dp, bottom = 8.dp, end = 5.dp)
            .clip(RoundedCornerShape(10.dp))

    ) {

        LinearProgressIndicator(
            progress = 0.35f,
            modifier = Modifier
                .height(12.dp)
                .fillMaxWidth()
                .background(PurpleGrey40),
            color = Color.Black
        )
    }
}

@Composable
fun GeneralOptionsUI(){
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        Text(
            text = "General",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        GeneralOptionItems(name = "Select")
    }
}

@Composable
fun GeneralOptionItems(name: String){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        item {
            Text(
                text = "Lead intention",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(textViewBg)
                    .padding(vertical = 5.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    text = name,
                    fontSize = 14.sp
                )
            }
            //
            Text(
                text = "AD Source",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(textViewBg)
                    .padding(vertical = 5.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    text = name,
                    fontSize = 14.sp
                )
            }
            //
            Text(
                text = "Country",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(textViewBg)
                    .border(1.5.dp, borderBg)
                    .padding(vertical = 5.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    text = name,
                    fontSize = 14.sp
                )
            }
            //
            Text(
                text = "Language",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(textViewBg)
                    .border(1.5.dp, borderBg)
                    .padding(vertical = 5.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    text = name,
                    fontSize = 14.sp
                )
            }
        }
    }

}
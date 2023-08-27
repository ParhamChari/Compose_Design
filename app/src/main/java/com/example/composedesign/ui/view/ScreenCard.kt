package com.example.composedesign.ui.view

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composedesign.R
import com.example.composedesign.data.model.MessageModel
import com.example.composedesign.utils.Constants


@Composable
fun HeaderPageScreen() {
    var isExpanded by remember { mutableStateOf(false) }

    Card(colors = CardDefaults.cardColors(containerColor = Color.LightGray), modifier = Modifier
        .padding(all = 8.dp)
        .fillMaxWidth()
        .clip(shape = ShapeDefaults.Large)
        .clickable { isExpanded = !isExpanded }) {

        if (isExpanded) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_1),
                    contentDescription = "profile",
                    modifier = Modifier
                        .size(130.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.5.dp, color = Color.Green, shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "User 1",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(Constants.messageData) {
                        ItemCardExpanded(messageModel = it)
                    }
                }

            }
        }
        else {
            Row(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_1),
                    contentDescription = "profile",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.5.dp, color = Color.Green, shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "User 1",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                )
            }
        }
    }
}


@Composable
fun ItemCardExpanded(messageModel: MessageModel) {
    var isExpanded by remember { mutableStateOf(false) }
    val surfaceColor by animateColorAsState(
        if (isExpanded) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.background,
        label = "",
    )

    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier.padding(all = 10.dp)
    ) {
        Image(
            painter = painterResource(id = messageModel.image),
            contentDescription = "profile",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(
                    width = 1.5.dp,
                    color = if (isExpanded) Color.Red else Color.Black,
                    shape = CircleShape
                ),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = messageModel.name,
                style = MaterialTheme.typography.titleMedium,
                color = if (isExpanded) Color.Red else Color.White
            )

            Spacer(modifier = Modifier.height(5.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = messageModel.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = if (isExpanded) MaterialTheme.typography.bodyLarge else MaterialTheme.typography.bodyMedium
                )
            }

        }
    }
}
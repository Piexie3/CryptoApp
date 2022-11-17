package com.manu.crypto.presentation.coin_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.unit.dp
import com.manu.crypto.data.remote.dto.TeamMember
import com.manu.crypto.ui.theme.Purple500

@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier =Modifier
) {
    Column(
        modifier=modifier,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.h6,
            color = Purple500
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.body2,
            fontStyle = Italic
        )
    }
}
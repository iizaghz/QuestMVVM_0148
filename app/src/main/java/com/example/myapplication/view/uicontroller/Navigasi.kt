package com.example.myapplication.view.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.model.DataJK.JenisK
import com.example.myapplication.view.FormSiswa
import com.example.myapplication.view.TampilSiswa
import com.example.myapplication.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail,
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    //edit 1 : parameter viewModel
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(modifier = modifier) { isiRuang ->
        //edit 2 : tambahkan variabel uiState
        val uiState = viewModel.statusUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(isiRuang),
        )
        
    }
}

private fun cancelAndBackToFormulir(
    navController: NavHostController,
) {
    navController.popBackStack(Navigasi.Formulir.name, inclusive = false)
}

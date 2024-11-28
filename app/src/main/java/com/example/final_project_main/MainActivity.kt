package com.example.final_project_main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.final_project_main.ui.theme.Final_project_mainTheme

class MainActivity : ComponentActivity() {
    private lateinit var eventViewModel: EventViewModel
    private lateinit var eventAdapter: EventAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        eventAdapter = EventAdapter(listOf()) // Start with an empty list
        recyclerView.adapter = eventAdapter

        enableEdgeToEdge()
        setContent {
            Final_project_mainTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                                eventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)

                                eventViewModel.allEvents.observe(this, Observer { events ->
                            // Update the cached copy of the events in the adapter.
                            events?.let {
                                eventAdapter = EventAdapter(it)
                                recyclerView.adapter = eventAdapter

                }
            })
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hi $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Final_project_mainTheme {
        Greeting("Android")
    }
}
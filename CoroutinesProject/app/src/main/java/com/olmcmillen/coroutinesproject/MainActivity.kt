package com.olmcmillen.coroutinesproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olmcmillen.coroutinesproject.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        layoutManager = LinearLayoutManager(this)
        binding.contentMain.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter(viewModel)
        binding.contentMain.recyclerView.adapter = adapter

        binding.button1.setOnClickListener(){
//            viewModel.addNames(binding.enterName.text.toString())
//            adapter?.notifyItemInserted(viewModel.getNames().size)

            suspend fun performTask(name : String): String {
                val delay = (1..10).random() * 1000
                val name = name

                delay(delay.toLong())
                return "The name is $name and the delay was $delay milliseconds."
            }

                coroutineScope.launch(Dispatchers.Main) {
                        viewModel.addNames(performTask(binding.enterName.text.toString()))
                        adapter?.notifyItemInserted(viewModel.getNames().size - 1)

                }




        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
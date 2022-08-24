package com.lefg095.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lefg095.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var listData: ArrayList<Data> = ArrayList()
    private lateinit var adapter: MyAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.result.observe(this, { succes ->
            if (succes){
                setData()
            }else{
                clearData()
            }
            initRecyclerView()
        })

        binding.btnAccion.setOnClickListener {
            viewModel.onSubmitClicked(listData)
        }
    }

    fun setData(){
        for(i in 1..5){
            listData.add(
                Data(
                    id = i,
                    name = "Producto",
                    description = "Producto numero ${i}"
                )
            )
        }
    }

    fun clearData(){
        listData.clear()
    }

    private fun initRecyclerView() {
        adapter = MyAdapter(listData, this)
        binding.rv.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rv.adapter = adapter
    }
}
package com.example.permissionxxxx

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.permissionxxx.PermissionX

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener(View.OnClickListener {
            PermissionX.request(this,
                android.Manifest.permission.CALL_PHONE,
                callback = fun(allGranted: Boolean, deniedList: List<String>) {
                    if (allGranted) {
                        call()
                    } else {
                        Toast.makeText(this, "You denied $deniedList", Toast.LENGTH_SHORT).show()
                    }
                })
        })
    }

    private fun call() {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$10086")
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
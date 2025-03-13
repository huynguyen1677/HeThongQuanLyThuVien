package com.example.hethongquanlythuvien

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.hethongquanlythuvien.Fragment.DanhSachSachFragment
import com.example.hethongquanlythuvien.Fragment.NhanVienFragment
import com.example.hethongquanlythuvien.Fragment.QuanLyFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Hiển thị Fragment Quản lý mặc định
        loadFragment(QuanLyFragment())

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_quan_ly -> loadFragment(QuanLyFragment())
                R.id.nav_danh_sach -> loadFragment(DanhSachSachFragment())
                R.id.nav_nhan_vien -> loadFragment(NhanVienFragment())
            }
            true
        }
    }

    // Hàm load Fragment
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }
}

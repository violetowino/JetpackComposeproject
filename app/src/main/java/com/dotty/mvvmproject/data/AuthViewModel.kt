package com.dotty.mvvmproject.data

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.navigation.NavHostController
import com.dotty.mvvmproject.models.User
import com.dotty.mvvmproject.navigation.ROUTE_DASHBOARD
import com.dotty.mvvmproject.navigation.ROUTE_LOGIN
import com.dotty.mvvmproject.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(var navController:NavHostController,
                    var context:Context) {
    var mAuth:FirebaseAuth
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()

    init {
        mAuth= FirebaseAuth.getInstance()
    }

    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }

    fun signup(
        username:String,
        email:String,
        password:String,
        confirmpassword:String
    ){
        if (username.isBlank() || email.isBlank() || password.isBlank() || confirmpassword.isBlank()) {
            showToast("Fill in all the details")
        } else if (password != confirmpassword) {
            showToast("Passwords do not match")
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = mAuth.currentUser
                    user?.let {
                        val userData = User(username, email, password, confirmpassword, it.uid)
                        saveUserDataToDatabase(userData)
                        // Perform UI operations on the main thread
                        Handler(Looper.getMainLooper()).post {
                            showToast("Registered Successfully")
                            navController.navigate(ROUTE_LOGIN)
                        }
                    }
                } else {
                    // Perform UI operations on the main thread
                    Handler(Looper.getMainLooper()).post {
                        showToast("Registration Failed: ${task.exception?.message}")
                        navController.navigate(ROUTE_REGISTER)
                    }
                }
            }
        }
    }

    private fun saveUserDataToDatabase(userData: User) {
        val userRef = database.reference.child("Users").child(mAuth.currentUser!!.uid)
        userRef.setValue(userData).addOnCompleteListener{ task ->
            if (task.isSuccessful){
                showToast("User data saved successfully")
            } else {
                showToast("Failed to save user data: ${task.exception?.message}")
            }
        }

    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }


    //LOGIN USER

    fun login(email: String, password: String){
        if (email.isBlank() || password.isBlank()){
            showToast("Fill in all the details")
        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    showToast("Logged in successfully")
                    navController.navigate(ROUTE_DASHBOARD)
                } else {
                    showToast("Login Failed: ${task.exception?.message}")
                }
            }
        }
    }

    //LOGOUT USER

    fun logout(){
        mAuth.signOut()
        showToast("Logged out successfully")
        navController.navigate(ROUTE_LOGIN)
    }
}

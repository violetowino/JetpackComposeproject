package com.dotty.mvvmproject.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.dotty.mvvmproject.models.Space
import com.dotty.mvvmproject.navigation.ROUTE_LOGIN
import com.google.firebase.database.FirebaseDatabase

class SpaceViewModel(var navController:NavHostController, var context: Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()){
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
    }

    fun saveSpace(time_in:String, time_out:String, date:String, space:String, amount:String){
        var id = System.currentTimeMillis().toString()
        var spaceData = Space(time_in, time_out, date, space, amount, id)
        var spaceRef = FirebaseDatabase.getInstance().getReference().child("Spaces/$id")
        progress.show()

        spaceRef.setValue(spaceData).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context, "Space selected", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}",Toast.LENGTH_LONG).show()
            }
        }
    }

//    fun viewSpace(
//        space: MutableState<Space>,
//        spaces: MutableList<Space>
//    ): SnapshotStateList<Space> {
//        var ref = FirebaseDatabase.getInstance().getReference().child("Spaces")
//
//        progress.show()
//        ref.addValueEventListener(object  : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                progress.dismiss()
//                spaces.clear()
//                for (snap in snapshot.children){
//                    val value = snap.getValue(Space::class.java)
//                    space.value = value!!
//                    spaces.add(value)
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(context, error.message, Toast.LENGTH_LONG).show()
//            }
//        })
//        return spaces
//    }


    fun updateSpace(time_in:String, time_out:String, date:String, space:String, amount:String, id:String){
        var updateRef = FirebaseDatabase.getInstance().getReference().child("Spaces/$id")
        progress.show()

        var updateData = Space(time_in, time_out, date, space, amount, id)
        updateRef.setValue(updateData).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context, "Update successful", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
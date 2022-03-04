package com.br.app5m.institutoblindarandroid

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.br.app5m.institutoblindarandroid.databinding.ActivityMainBinding

import android.widget.TextView
import android.graphics.drawable.ColorDrawable

import com.squareup.picasso.Picasso

import android.graphics.drawable.Drawable

import android.animation.PropertyValuesHolder

import android.animation.ObjectAnimator

import android.graphics.drawable.LayerDrawable

import android.view.Gravity

import android.graphics.drawable.BitmapDrawable

import android.graphics.Bitmap

import android.util.TypedValue

import android.app.Activity
import android.widget.Toast
import com.squareup.picasso.Picasso.LoadedFrom
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    var textCartItemCount: TextView? = null
    var mCartItemCount = 10
    private lateinit var logoTarget: com.squareup.picasso.Target

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.main_nav_host) //Initialising navController

        appBarConfiguration = AppBarConfiguration.Builder( R.id.myCallsFrag,
            R.id.mainMenuFrag, R.id.navigation_home) //Pass the ids of fragments from nav_graph which you d'ont want to show back button in toolbar
            .build()
        setSupportActionBar(binding.mainToolbar) //Set toolbar

        setupActionBarWithNavController(navController, appBarConfiguration) //Setup toolbar with back button and drawer icon according to appBarConfiguration


        visibilityNavElements(navController) //If you want to hide drawer or bottom navigation configure that in this function


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu_item, menu)
        val menuItemNotify: MenuItem = menu.findItem(R.id.action_notify)
        val actionView: View = menuItemNotify.getActionView()
        textCartItemCount = actionView.findViewById<View>(R.id.cart_badge) as TextView
        setupBadge()
        actionView.setOnClickListener { onOptionsItemSelected(menuItemNotify) }


        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.navigation_home) {
                menuItemNotify.setVisible(true)
            } else {
                menuItemNotify.setVisible(false)
            }
            if (destination.id == R.id.detailCallFrag) {
                supportActionBar?.setTitle("Detalhes do chamado")
            }
            if (destination.id == R.id.newCallFrag) {
                supportActionBar?.setTitle("Abrir Chamado")
            }
            if (destination.id == R.id.sendingAudioFragment) {
                supportActionBar?.setTitle("Gravar Áudio")
            }
            if (destination.id == R.id.profileFrag) {
                supportActionBar?.setTitle("Meu Perfil")
            }
        }


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_notify -> {

                // Do something
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBadge() {
        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount!!.visibility != View.GONE) {
                    textCartItemCount!!.visibility = View.GONE
                }
            } else {
                textCartItemCount!!.text = Math.min(mCartItemCount, 99).toString()
                if (textCartItemCount!!.visibility != View.VISIBLE) {
                    textCartItemCount!!.visibility = View.VISIBLE
                }
            }
        }
    }
    private fun visibilityNavElements(navController: NavController) {

        //Listen for the change in fragment (navigation) and hide or show drawer or bottom navigation accordingly if required
        //Modify this according to your need
        //If you want you can implement logic to deselect(styling) the bottom navigation menu item when drawer item selected using listener

        supportActionBar?.show()
        supportActionBar?.setDisplayShowCustomEnabled(true)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home ->{

                    supportActionBar?.setDisplayShowTitleEnabled(false)
                    showActionBarLogoFade(this, true)

                    showBothNavigation()
                }
                R.id.myCallsFrag ->{
                    supportActionBar?.setDisplayShowTitleEnabled(false)
                    showActionBarLogo(this, true)

                    showBothNavigation()

                }
                R.id.mainMenuFrag ->{
                    supportActionBar?.setDisplayShowTitleEnabled(false)
                    showActionBarLogo(this, true)

                    showBothNavigation()
                }
                else ->{


                    showActionBarLogoFade(this, false)

                    supportActionBar?.setDisplayShowTitleEnabled(true)

                    hideBottomNavigation()
                }
            }
        }

    }
    fun showActionBarLogoFade(activity: Activity, show: Boolean) {
        if (show) {
            // Calculate Action bar height
            var actionBarHeight = 200
            val tv = TypedValue()
            if (activity.theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                actionBarHeight = TypedValue.complexToDimensionPixelSize(
                    tv.data,
                    activity.resources.displayMetrics
                )
            }

            // Using action bar background drawable
             logoTarget = object :com.squareup.picasso.Target {
                override fun onBitmapLoaded(bitmap: Bitmap?, from: LoadedFrom?) {
                    val layers = arrayOfNulls<Drawable>(2)
                    layers[0] = ColorDrawable( resources.getColor(R.color.colorPrimary)) // Background color of Action bar
                    val bd = BitmapDrawable(activity.resources, bitmap)
                    bd.gravity = Gravity.CENTER
                    val drawLogo: Drawable = bd
                    layers[1] = drawLogo // Bitmap logo of Action bar (loaded from Picasso)
                    val layerDrawable = LayerDrawable(layers)
                    layers[1]!!.alpha = 0
                    (activity as AppCompatActivity).supportActionBar!!.setBackgroundDrawable(
                        layerDrawable
                    )
                    val animator = ObjectAnimator.ofPropertyValuesHolder(
                        layers[1],
                        PropertyValuesHolder.ofInt("alpha", 255)
                    )
                    animator.target = layers[1]
                    animator.duration = 2000
                    animator.start()
                }

                 override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                     Toast.makeText(this@MainActivity, e?.localizedMessage, Toast.LENGTH_SHORT).show()

                 }

                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

                }
            }
            Picasso.get()
                .load( R.drawable.blindar_branco)
                .resize(0, actionBarHeight).into(logoTarget)
        } else {
            (activity as AppCompatActivity).supportActionBar!!.setBackgroundDrawable(
                ColorDrawable(
                    resources.getColor(R.color.colorPrimary)
                )
            )
        }
    }

    fun showActionBarLogo(activity: Activity, show: Boolean) {
        if (show) {
            // Calculate Action bar height
            var actionBarHeight = 200
            val tv = TypedValue()
            if (activity.theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                actionBarHeight = TypedValue.complexToDimensionPixelSize(
                    tv.data,
                    activity.resources.displayMetrics
                )
            }

            // Using action bar background drawable
            logoTarget = object :com.squareup.picasso.Target {
                override fun onBitmapLoaded(bitmap: Bitmap?, from: LoadedFrom?) {
                    val layers = arrayOfNulls<Drawable>(2)
                    layers[0] = ColorDrawable( resources.getColor(R.color.colorPrimary)) // Background color of Action bar
                    val bd = BitmapDrawable(activity.resources, bitmap)
                    bd.gravity = Gravity.CENTER
                    val drawLogo: Drawable = bd
                    layers[1] = drawLogo // Bitmap logo of Action bar (loaded from Picasso)
                    val layerDrawable = LayerDrawable(layers)
                    layers[1]!!.alpha = 0
                    (activity as AppCompatActivity).supportActionBar!!.setBackgroundDrawable(
                        layerDrawable
                    )
                    val animator = ObjectAnimator.ofPropertyValuesHolder(
                        layers[1],
                        PropertyValuesHolder.ofInt("alpha", 255)
                    )
                    animator.target = layers[1]
                    animator.duration = 0
                    animator.start()
                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                    Toast.makeText(this@MainActivity, e?.localizedMessage, Toast.LENGTH_SHORT).show()

                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

                }
            }
            Picasso.get()
                .load( R.drawable.blindar_branco)
                .resize(0, actionBarHeight).into(logoTarget)
        } else {
            (activity as AppCompatActivity).supportActionBar!!.setBackgroundDrawable(
                ColorDrawable(
                    resources.getColor(R.color.colorPrimary)
                )
            )
        }
    }

    private fun hideBothNavigation() { //Hide both drawer and bottom navigation bar
        binding.mainBottomNavigationView.visibility = View.GONE
    }

    private fun hideBottomNavigation() { //Hide bottom navigation
        binding.mainBottomNavigationView.visibility = View.GONE

    }

    private fun showBothNavigation() {
        binding.mainBottomNavigationView.visibility = View.VISIBLE

        setupNavControl() //To configure navController with drawer and bottom navigation
    }

    private fun setupNavControl() {
        binding.mainBottomNavigationView.setupWithNavController(navController) //Setup Bottom navigation with navController
    }

    fun exitApp() { //To exit the application call this function from fragment
        this.finishAffinity()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = navController
        return when(navController.currentDestination?.id) {
            R.id.navigation_home -> {
                finish()
                true
            }
            else -> navController.navigateUp()
        }
        //Setup appBarConfiguration for back arrow
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }



/*    override fun onBackPressed() {

        when { //If drawer layout is open close that on back pressed


            }
            else -> {
                super.onBackPressed() //If drawer is already in closed condition then go back
            }
        }
    }*/
}
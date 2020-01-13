package com.example.androidapp.model

class DrawerMenuItem() {
    var itemNeki: Int = 0
    var itemType: Int = 0

    constructor( itemType: Int) : this(){
        this.itemType = itemType
    }

    companion object {
        const val ROW_HEADER = 1
        const val ROW_FOOTER = 2
        const val ROW_BODY = 3
    }
}
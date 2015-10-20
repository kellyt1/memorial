package com.memorial

class Victim {

     Long id
     Long version

     String victimFirstName
     String vicitimLastName
     String victimAddress

    static belongsTo = Memorial

    static constraints = {
        victimFirstName(nullable:true, blank:true)
        vicitimLastName(nullable:true, blank:true)
        victimAddress(nullable:true,blank:true)
    }
}

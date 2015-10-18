package com.memorial

import jdk.nashorn.internal.objects.annotations.Property

class Victim {

    @Property Long id
    @Property Long version

    @Property String victimFirstName
    @Property String vicitimLastName
    @Property String victimAddress

    @Property belongsTo = Memorial

    static constraints = {
        victimFirstName(nullable:true, blank:true)
        vicitimLastName(nullable:true, blank:true)
        victimAddress(nullable:true,blank:true)
    }
}

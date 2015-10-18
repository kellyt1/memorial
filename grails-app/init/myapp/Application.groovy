package myapp

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)

        grails.gorm.default.constraints = {
            myShared(nullable:false, blank:false, size:1..1000)
        }
    }

}
package com.example.yogatrain.posedetection.classification


@Suppress("EnumEntryName", "SpellCheckingInspection")
    enum class YogaPoseClass {
        UNKNOWN,
        adho_mukha_svanasana,
        bhujangasana,
        bidalasana,
        phalakasana,
        ustrasana,
        utkatasana,
        utkata_konasana,
        virabhadrasana_i,
        virabhadrasana_ii,
        vrikshasana;

        fun getFormattedString(): String {
            val string = when (this) {
                UNKNOWN -> "Unknown"
                adho_mukha_svanasana -> "DownDog"
                bhujangasana -> "Cobra"
                phalakasana -> "Plank"
                ustrasana -> "Camel"
                utkatasana -> "Chair"
                virabhadrasana_i -> "Warrior1"
                virabhadrasana_ii -> "Warrior2"
                utkata_konasana -> "Godess"
                bidalasana -> "Cow"
                vrikshasana -> "Tree"
            }
            return string
        }
    }
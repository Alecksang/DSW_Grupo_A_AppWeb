package com.ucab.cmcapp.common.entities;

public class Usuario {
        private int user_ID;
        private String user_nombre;
        private String user_apellido;

        public Usuario(int user_ID, String user_nombre, String user_apellido) {
            this.user_ID = user_ID;
            this.user_nombre = user_nombre;
            this.user_apellido = user_apellido;
        }

        // Getters and setters for the attributes
        public int getUser_ID() {
            return user_ID;
        }

        public void setUser_ID(int user_ID) {
            this.user_ID = user_ID;
        }

        public String getUser_nombre() {
            return user_nombre;
        }

        public void setUser_nombre(String user_nombre) {
            this.user_nombre = user_nombre;
        }

        public String getUser_apellido() {
            return user_apellido;
        }

        public void setUser_apellido(String user_apellido) {
            this.user_apellido = user_apellido;
        }

}



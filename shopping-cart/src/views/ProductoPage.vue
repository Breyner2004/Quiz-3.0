<template>
    <ion-page>
      <ion-header :translucent="true">
        <ion-toolbar>
          <ion-title>Prodcuto</ion-title>
        </ion-toolbar>
      </ion-header>  
      <ion-content>       
        <div id="login-container">  
          <div id="login-form">
            <InputComponent id="id" name="id" type="hidden"/>
            <InputComponent id="codigo" name="codigo" label="Código: " />
            <InputComponent id="nombre" name="nombre" label="Nombre: " />
            <InputComponent id="marca" name="marca" label="Marca: " />
            <InputComponent type="number" id="precio" name="precio" label="Precio: " />
            <InputComponent type="number" id="stock" name="stock" label="Stock: " disabled="disabled" />
          </div>
  
          <div> 
             <!--Traer el componente de los botones de la crud  -->
             <CrudButtonComponentProducto @findAllRecords="findAllRecords" @updateRecord="updateRecord" @deleteRecordPhysical="deleteRecordPhysical" @deleteRecordLogical="deleteRecordLogical"/>
          </div>         
        </div>
      </ion-content>
    </ion-page>
  </template>
  
  <script setup lang="ts">
  import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
  import InputComponent from '@/components/InputComponent.vue';
  import CrudButtonComponentProducto from '@/components/CrudButtonComponentProducto.vue';
  import axios from 'axios';
// Rutas de la API
const baseURL = 'http://localhost:8080/shopping_car/api/producto';

// Métodos para interactuar con la API
// Obtener todos los registros
async function findAllRecords() {
  try {
    const response = await axios.get(baseURL);
    return response.data;
  } catch (error) {
    console.error('Error al obtener todos los registros:', error);
    throw error;
  }
}

// Obtener por ID
async function fetchRecordById(id) {
  try {
    const response = await axios.get(`${baseURL}/${id}`);
    return response.data;
  } catch (error) {
    console.error('Error al obtener el registro por ID:', error);
    throw error;
  }
}

/* Crear registro
async function createRecord() {
  const data = {
    codigo: codigo.value,
    nombre: nombre.value,
    marca: marca.value,
    precio: precio.value,
    stock: stock.value
  };

  try {
    const response = await axios.post(baseURL, data);
    console.log('Registro creado exitosamente:', response.data);
  } catch (error) {
    console.error('Error al crear el registro:', error);
  }
}*/


// Actualizar registro
async function updateRecord(id, data) {
  try {
    const response = await axios.put(`${baseURL}/${id}`, data);
    return response.data;
  } catch (error) {
    console.error('Error al actualizar el registro:', error);
    throw error;
  }
}

// Eliminar registro físico
async function deleteRecordPhysical(id) {
  try {
    const response = await axios.delete(`${baseURL}/${id}`);
    return response.data;
  } catch (error) {
    console.error('Error al eliminar el registro físico:', error);
    throw error;
  }
}

// Eliminado lógico
async function deleteRecordLogical(id) {
  try {
    const response = await axios.put(`${baseURL}/delete-logical/${id}`);
    return response.data;
  } catch (error) {
    console.error('Error al realizar el eliminado lógico:', error);
    throw error;
  }
}
</script>
  
  <style scoped src="../theme/container.css"></style>


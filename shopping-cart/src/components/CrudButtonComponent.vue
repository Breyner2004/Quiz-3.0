<!-- CrudButtonComponent.vue -->
<template>
  <div>
    <ButtonComponent id="find" value="Consultar todo" expand="full" color="warning" nameMethod="findAllRecords" @click="handleClickFind"/>    
    <ButtonComponent id="created" value="Agregar" expand="full" color="warning" nameMethod="createRecord" @click="handleClickCreate"/>
    <ButtonComponent id="updated" value="Modificar" expand="full" color="warning" nameMethod="updateRecord"  @click="handleClickUpdate"/>
    <ButtonComponent id="deleted" value="Eliminar" expand="full" color="warning" nameMethod="deleteRecordPhysical" @click="handleClickDelete" />    
    <ButtonComponent id="deletedLogical" value="Eliminar lógicamente" expand="full" color="warning" nameMethod="deleteRecordLogical" @click="handleClickDeleteLogical" />    
  </div>
</template>

<script setup lang="ts">
  import ButtonComponent from '@/components/ButtonComponent.vue';
  import { defineEmits } from 'vue';

  // Definir los eventos que se emitirán en el componente
  const emit = defineEmits(['createRecord', 'updateRecord', 'deleteRecordPhysical', 'deleteRecordLogical', 'findAllRecords']);

  // Método para manejar el clic en el botón de crear
  const handleClickCreate = () => {
    emit('createRecord');
  };

  // Método para manejar el clic en el botón de actualizar
  const handleClickUpdate = () => {
    emit('updateRecord');
  };

  // Método para manejar el clic en el botón de eliminar
  const handleClickDelete = () => {
    emit('deleteRecordPhysical');
  };

  // Método para manejar el clic en el botón de eliminar lógicamente
  const handleClickDeleteLogical = () => {
    emit('deleteRecordLogical');
  };

  // Método para manejar el clic en el botón de consultar
    const handleClickFind = () => {
      emit('findAllRecords');
  };
</script>

<style scoped src="../theme/container.css"></style>

package com.excelbd.logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.excelbd.dtos.PersonaDTO;

public class LectorExcel {

	private static List<PersonaDTO> listaPersonas = new ArrayList<>();

	/**
	 * Metodo encargado de cargar la lista de personasDTO de un excel
	 */
	public static void cargarPersonasExcel() {
		try {
			// Abrir el archivo de Excel
			FileInputStream archivo = new FileInputStream(
					new File("C:\\Users\\Sebastian Alzate\\Desktop\\cedulasPrueba.xlsx"));

			// Crear un objeto de la clase XSSFWorkbook para representar el archivo de Excel
			XSSFWorkbook libroExcel = new XSSFWorkbook(archivo);

			// Obtener la primera hoja del libro de Excel (poner el nombre de la hoja)
			org.apache.poi.ss.usermodel.Sheet hoja = libroExcel.getSheet("Hoja1");
			int rowCount = hoja.getLastRowNum() - hoja.getFirstRowNum();

			// Iterar sobre cada fila de la hoja
			for (int i = 1; i <= rowCount; i++) {
				Row row = hoja.getRow(i);
				PersonaDTO persona = new PersonaDTO();
				persona.setCedula((long) row.getCell(0).getNumericCellValue());
				persona.setNombre(row.getCell(1).getStringCellValue());
				persona.setProfesion(row.getCell(2).getStringCellValue());
				
				listaPersonas.add(persona);
			}

			// Cerrar el archivo de Excel
			archivo.close();
			libroExcel.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo encargado de mostrar la lista de personas cargadas del excel
	 */
	public static void mostarPersonasCargadas() {
		for (PersonaDTO personaDTO : listaPersonas) {
			System.out.println(personaDTO.toString());
		}
	}
	
	public static PersonaDTO consultarPersonaPorId(Long cedula) {
		  return listaPersonas.stream()
			        .filter(personaDTO -> personaDTO.getCedula().equals(cedula))
			        .findFirst()
			        .orElse(null);
	}

	public static void main(String[] args) {
		cargarPersonasExcel();
		mostarPersonasCargadas();
	}
}

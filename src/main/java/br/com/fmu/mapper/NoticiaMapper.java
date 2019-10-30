package br.com.fmu.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fmu.dto.NoticiaDto;
import br.com.fmu.model.Noticia;

public class NoticiaMapper {
	
	/*
	 * public static Noticia convertFromDto(NoticiaDto from) { if(from == null) {
	 * return null; } Noticia model = new Noticia();
	 * 
	 * model.setId(from.getId());
	 * 
	 * model.setDia(from.getDia()); model.setLink(from.getLink());
	 * model.setTexto(from.getTexto()); model.setTitulo(from.getTitulo());
	 * 
	 * return model; }
	 */
	
	public static NoticiaDto convertToDto(Noticia from) {
		if(from == null) {
			return null;
		}
		NoticiaDto model = new NoticiaDto();
		
		model.setId(from.getId());
		
		model.setLink(from.getLink());
		model.setTexto(from.getTexto());
		model.setTitulo(from.getTitulo());
		model.setImg(from.getImg());
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFormatada = new Date();

		try {
			dataFormatada = fmt.parse(from.getData().toString());
			model.setData(new SimpleDateFormat("dd/MM/yyyy").format(dataFormatada));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;
	}
	
	/*
	 * public static List<Noticia> convertToListEntity(List<NoticiaDto> lstDto) {
	 * List<Noticia> lstSaida = new ArrayList<Noticia>(); if(lstDto != null) {
	 * for(int i = 0; i < lstDto.size(); i++) {
	 * lstSaida.add(convertFromDto(lstDto.get(i))); } }
	 * 
	 * return lstSaida; }
	 */
	
	public static List<NoticiaDto> convertToListDto(List<Noticia> lstEntity) {
		List<NoticiaDto> lstSaida = new ArrayList<NoticiaDto>(); 
		if(lstEntity != null) {
			for(int i = 0; i < lstEntity.size(); i++) {
				lstSaida.add(convertToDto(lstEntity.get(i)));
			}
		}
		
		return lstSaida;
	}


}

package com.company.enroller.persistence;

import java.util.Collection;

import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.company.enroller.model.Participant;

@Component("participantService")
public class ParticipantService {

	DatabaseConnector connector;

	public ParticipantService() {
		connector = DatabaseConnector.getInstance();
	}

	public Collection<Participant> getAll() {
		return connector.getSession().createCriteria(Participant.class).list();//tutaj piszemy zapytania to jest do hibernate
	}
	

	public Participant findByLogin(String login) { //dodajemy
		return (Participant) connector.getSession().get(Participant.class, login);
	}
	
	public void add(Participant participant){
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().save(participant);
		transaction.commit();
	}
	
	public void delete(Participant participant){
		Transaction transaction1 = connector.getSession().beginTransaction();
		connector.getSession().delete(participant);
		transaction1.commit();
	}
	public void update(Participant participant){
		Transaction updatetransaction1 = connector.getSession().beginTransaction();
		connector.getSession().update(participant);
		updatetransaction1.commit();
}
}
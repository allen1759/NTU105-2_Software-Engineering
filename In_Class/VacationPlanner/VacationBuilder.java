public abstract class VacationPlanner{

	protected Vacation vacation;

	public void chooseHotel(String hotel){
		vacation.setHotel(hotel);
	}
	public void chooseAdmissionTickets(String tix){
		vacation.setAdmissionTickets(tix);
	}
	public void makeRestaurantReservations(String res){
		vacation.setRestaurantReservations(res);
	}
	public void bookSpecialEvents(String events){
		vacation.setSpecialEvents(events);
	}
	public void bookDay(String day){
		vacation.setDay(day);
	}

	public Vacation getVacation(){
		return this.vacation;
	}

}
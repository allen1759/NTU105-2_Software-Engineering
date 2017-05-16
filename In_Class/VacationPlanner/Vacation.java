public abstract class Vacation{

	protected String type;
	private   String hotel, day, specialEvent, reservation, ticket;

	public void setHotel(String hotel){
		this.hotel = hotel;
	}
	public void setAdmissionTickets(String tix){
		this.ticket = tix;
	}
	public void setRestaurantReservations(String res){
		this.reservation = res;
	}
	public void setSpecialEvents(String events){
		this.specialEvent = events;
	}
	public void setDay(String day){
		this.day = day;
	}

	public void printVacation(){
		System.out.println(this.type);
		System.out.println("Day:"+(this.day==null ? "" : this.day));
		System.out.println("Hotel:"+(this.hotel==null ? "" : this.hotel));
		System.out.println("Reservation:"+(this.reservation==null ? "" : this.reservation));
		System.out.println("SpecialEvent:"+(this.specialEvent==null ? "" : this.specialEvent));
		System.out.print("Tickets:"+(this.ticket==null ? "" : this.ticket));
	}

}
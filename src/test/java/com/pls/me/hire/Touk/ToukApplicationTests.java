package com.pls.me.hire.Touk;

import com.pls.me.hire.Touk.Driver.Driver;
import com.pls.me.hire.Touk.Driver.DriverType;
import com.pls.me.hire.Touk.Ticket.Ticket;
import com.pls.me.hire.Touk.Ticket.TicketNotFoundException;
import com.pls.me.hire.Touk.Ticket.TicketRepository;
import com.pls.me.hire.Touk.Ticket.TicketServiceImplementation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ToukApplicationTests {

		@Mock
		TicketRepository ticketMock;

		@InjectMocks
		TicketServiceImplementation ticketService;

		private Driver returnDriver(DriverType driverType){
			Driver driver = new Driver();
			driver.setType(driverType);
			return driver;
		}

		private Ticket returnTicket(DriverType driverType, long minutes){
			Ticket ticket = new Ticket();
			ticket.setStartTime(ZonedDateTime.now().minusMinutes(minutes));
			ticket.setDriver(returnDriver(driverType));
			return ticket;
		}

		@Test
		public void vipUpdate(){
			Ticket test = returnTicket(DriverType.VIP, 200);
			when(ticketMock.getOne(anyLong())).thenReturn(test);
			when(ticketMock.existsById(anyLong())).thenReturn(true);

			ticketService.updateTicket(5);

			Assert.assertEquals(7.28,test.getPrice(),0);



		}

		@Test
		public void regularUpdate(){
			Ticket test = returnTicket(DriverType.REGULAR, 200);
			when(ticketMock.getOne(anyLong())).thenReturn(test);
			when(ticketMock.existsById(anyLong())).thenReturn(true);


			ticketService.updateTicket(5);

			Assert.assertEquals(10.5,test.getPrice(),0);
		}

		@Test
		public void vipFirstHourUpdate(){

			Ticket test = returnTicket(DriverType.VIP, 20);
			when(ticketMock.getOne(anyLong())).thenReturn(test);
			when(ticketMock.existsById(anyLong())).thenReturn(true);


			ticketService.updateTicket(5);

			Assert.assertEquals(0,test.getPrice(),0);

		}

		@Test
		public void regularFirstHourUpdate(){

			Ticket test = returnTicket(DriverType.REGULAR,20);
			when(ticketMock.getOne(anyLong())).thenReturn(test);
			when(ticketMock.existsById(anyLong())).thenReturn(true);


			ticketService.updateTicket(5);

			Assert.assertEquals(1,test.getPrice(),0);


		}

		@Test(expected=TicketNotFoundException.class)
		public void nonExistingTicketUpdate(){
			when(ticketMock.existsById(anyLong())).thenReturn(false);
			ticketService.updateTicket(5);

		}
		@Test(expected=TicketNotFoundException.class)
		public void nonExistingTicket(){
		when(ticketMock.existsById(anyLong())).thenReturn(false);
		ticketService.getTicketById(5);

		}





}

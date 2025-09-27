package com.app.HandyMan.Config;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.HandyMan.Entity.Admin;
import com.app.HandyMan.Entity.Booking;
import com.app.HandyMan.Entity.Handyman;
import com.app.HandyMan.Entity.Job;
import com.app.HandyMan.Entity.Notification;
import com.app.HandyMan.Entity.Payment;
import com.app.HandyMan.Entity.Review;
import com.app.HandyMan.Entity.ServiceCategory;
import com.app.HandyMan.Entity.SupportTicket;
import com.app.HandyMan.Entity.User;
import com.app.HandyMan.Enums.PaymentMethod;
import com.app.HandyMan.Enums.PaymentStatus;
import com.app.HandyMan.Repository.AdminRepo;
import com.app.HandyMan.Repository.BookingRepo;
import com.app.HandyMan.Repository.HandymanRepo;
import com.app.HandyMan.Repository.JobRepo;
import com.app.HandyMan.Repository.NotificationRepo;
import com.app.HandyMan.Repository.PaymentRepo;
import com.app.HandyMan.Repository.ReviewRepo;
import com.app.HandyMan.Repository.ServiceCategoryRepo;
import com.app.HandyMan.Repository.SupportTicketRepo;
import com.app.HandyMan.Repository.UserRepo;
import com.app.HandyMan.Service.AdminService;
import com.app.HandyMan.Service.BookingService;
import com.app.HandyMan.Service.HandymanService;
import com.app.HandyMan.Service.JobService;
import com.app.HandyMan.Service.NotificationService;
import com.app.HandyMan.Service.PaymentService;
import com.app.HandyMan.Service.ReviewService;
import com.app.HandyMan.Service.ServiceCategoryService;
import com.app.HandyMan.Service.SupportTicketService;
import com.app.HandyMan.Service.UserService;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired private UserService userService;
    @Autowired private AdminService adminService;
    @Autowired private HandymanService handymanService;
    @Autowired private ServiceCategoryService serviceCategoryService;
    @Autowired private JobService jobService;
    @Autowired private BookingService bookingService;
    @Autowired private PaymentService paymentService;
    @Autowired private ReviewService reviewService;
    @Autowired private NotificationService notificationService;
    @Autowired private SupportTicketService supportTicketService;

    @Override
    public void run(String... args) throws Exception {
//        // --- USERS ---
//        User u1 = new User(); u1.setName("Yuvraj Singh Paliwal"); u1.setEmail("yuvi@gmail.com"); u1.setPhone("9876543210"); u1.setPassword("Yuvi@123");
//        User u2 = new User(); u2.setName("Navpreet Singh panesar"); u2.setEmail("nav@example.com"); u2.setPhone("9123456780"); u2.setPassword("Nav@123");
//        User u3 = new User(); u3.setName("John Doe"); u3.setEmail("john@example.com"); u3.setPhone("9988776655");
//        User u4 = new User(); u4.setName("Priya Singh"); u4.setEmail("priya@example.com"); u4.setPhone("9000000000");
//        User u5 = new User(); u5.setName("Aman Verma"); u5.setEmail("aman@example.com"); u5.setPhone("9111111111");
//        userService.save(u1);
//        userService.save(u2);
//        userService.save(u3);
//        userService.save(u4);
//        userService.save(u5);
//
//        // --- ADMINS ---
//        Admin a1 = new Admin(); a1.setUsername("admin1"); a1.setPassword("pass"); a1.setEmail("admin1@sys.com");
//        Admin a2 = new Admin(); a2.setUsername("admin2"); a2.setPassword("pass"); a2.setEmail("admin2@sys.com");
//        Admin a3 = new Admin(); a3.setUsername("superadmin"); a3.setPassword("super"); a3.setEmail("super@sys.com");
//        Admin a4 = new Admin(); a4.setUsername("opsadmin"); a4.setPassword("ops"); a4.setEmail("ops@sys.com");
//        Admin a5 = new Admin(); a5.setUsername("reviewadmin"); a5.setPassword("rev"); a5.setEmail("rev@sys.com");
//        adminService.save(a1);
//        adminService.save(a2);
//        adminService.save(a3);
//        adminService.save(a4);
//        adminService.save(a5);
//
//        // --- HANDYMEN ---
//        Handyman h1 = new Handyman(); h1.setName("Raj Electrician"); h1.setContactDetails("9871112222"); h1.setLocation("Delhi");
//        Handyman h2 = new Handyman(); h2.setName("Amit Plumber"); h2.setContactDetails("9873334444"); h2.setLocation("Noida");
//        Handyman h3 = new Handyman(); h3.setName("Suresh Carpenter"); h3.setContactDetails("9875556666"); h3.setLocation("Gurgaon");
//        Handyman h4 = new Handyman(); h4.setName("Vikas Painter"); h4.setContactDetails("9877778888"); h4.setLocation("Delhi");
//        Handyman h5 = new Handyman(); h5.setName("Manish AC Mechanic"); h5.setContactDetails("9879990000"); h5.setLocation("Faridabad");
//        handymanService.save(h1);
//        handymanService.save(h2);
//        handymanService.save(h3);
//        handymanService.save(h4);
//        handymanService.save(h5);
//
//        // --- SERVICE CATEGORIES ---
//        ServiceCategory c1 = new ServiceCategory("Electrical", "Fan, lights, wiring and electrical repair", 500.0, "icons/electrical.png", true);
//        ServiceCategory c2 = new ServiceCategory("Plumbing", "Fix sinks, taps, leakages and pipes", 400.0, "icons/plumbing.png", true);
//        ServiceCategory c3 = new ServiceCategory("Carpentry", "Furniture repair, shelves, and woodwork", 600.0, "icons/carpentry.png", true);
//        ServiceCategory c4 = new ServiceCategory("Painting", "Wall painting, polishing and touch-ups", 800.0, "icons/painting.png", true);
//        ServiceCategory c5 = new ServiceCategory("AC Repair", "Air conditioning servicing and repair", 1000.0, "icons/ac.png", true);
//        ServiceCategory c6 = new ServiceCategory("Driver on Demand", "Hire a personal driver for a day", 700.0, "icons/driver.png", true);
//        ServiceCategory c7 = new ServiceCategory("Home Decoration", "Interior design and decoration services", 2000.0, "icons/decorator.png", true);
//        ServiceCategory c8 = new ServiceCategory("Cleaning Services", "Home and office deep cleaning", 1200.0, "icons/cleaning.png", true);
//        ServiceCategory c9 = new ServiceCategory("Appliance Repair", "Washing machine, fridge, microwave repair", 900.0, "icons/appliance.png", true);
//        ServiceCategory c10 = new ServiceCategory("Gardening", "Garden care, lawn mowing, plant care", 500.0, "icons/gardening.png", true);
//        ServiceCategory c11 = new ServiceCategory("Pest Control", "Cockroach, termite, mosquito treatments", 1500.0, "icons/pest.png", true);
//        ServiceCategory c12 = new ServiceCategory("IT Support", "Computer, laptop, and network issues", 600.0, "icons/it.png", true);
//        ServiceCategory c13 = new ServiceCategory("Moving/Packers", "Packers and movers for relocation", 2500.0, "icons/moving.png", true);
//        ServiceCategory c14 = new ServiceCategory("Security Services", "Hire security guards, CCTV installation", 1800.0, "icons/security.png", true);
//        ServiceCategory c15 = new ServiceCategory("Laundry/Ironing", "Washing, drying, folding and ironing", 300.0, "icons/laundry.png", true);
//        ServiceCategory c16 = new ServiceCategory("Cooking/Chef on Demand", "Hire a cook or chef for home/events", 1500.0, "icons/chef.png", true);
//        ServiceCategory c17 = new ServiceCategory("Tutoring", "Tutors for school and college subjects", 500.0, "icons/tutoring.png", true);
//        ServiceCategory c18 = new ServiceCategory("Beauty & Salon", "Salon and grooming at home", 800.0, "icons/salon.png", true);
//        serviceCategoryService.save(c1);
//        serviceCategoryService.save(c2);
//        serviceCategoryService.save(c3);
//        serviceCategoryService.save(c4);
//        serviceCategoryService.save(c5);
//        serviceCategoryService.save(c6);
//        serviceCategoryService.save(c7);
//        serviceCategoryService.save(c8);
//        serviceCategoryService.save(c9);
//        serviceCategoryService.save(c10);
//        serviceCategoryService.save(c11);
//        serviceCategoryService.save(c12);
//        serviceCategoryService.save(c13);
//        serviceCategoryService.save(c14);
//        serviceCategoryService.save(c15);
//        serviceCategoryService.save(c16);
//        serviceCategoryService.save(c17);
//        serviceCategoryService.save(c18);
//
//        // --- JOBS ---
//        Job j1 = new Job(); j1.setCustomer(u1); j1.setHandyman(h1); j1.setServiceCategory(c1); j1.setDescription("Fan repair");
//        Job j2 = new Job(); j2.setCustomer(u2); j2.setHandyman(h2); j2.setServiceCategory(c2); j2.setDescription("Fix kitchen sink");
//        Job j3 = new Job(); j3.setCustomer(u3); j3.setHandyman(h3); j3.setServiceCategory(c3); j3.setDescription("Make wooden shelf");
//        Job j4 = new Job(); j4.setCustomer(u4); j4.setHandyman(h4); j4.setServiceCategory(c4); j4.setDescription("Repaint living room");
//        Job j5 = new Job(); j5.setCustomer(u5); j5.setHandyman(h5); j5.setServiceCategory(c5); j5.setDescription("AC gas refill");
//        jobService.save(j1);
//        jobService.save(j2);
//        jobService.save(j3);
//        jobService.save(j4);
//        jobService.save(j5);
//
//        // --- BOOKINGS ---
//        Booking b1 = new Booking(); b1.setJob(j1); b1.setBookingDateTime(LocalDateTime.now()); b1.setTotalFare(500.0); b1.setPaymentMethod(PaymentMethod.CASH); b1.setPaymentStatus(PaymentStatus.SUCCESS);
//        Booking b2 = new Booking(); b2.setJob(j2); b2.setBookingDateTime(LocalDateTime.now()); b2.setTotalFare(800.0); b2.setPaymentMethod(PaymentMethod.UPI); b2.setPaymentStatus(PaymentStatus.SUCCESS);
//        Booking b3 = new Booking(); b3.setJob(j3); b3.setBookingDateTime(LocalDateTime.now()); b3.setTotalFare(1200.0); b3.setPaymentMethod(PaymentMethod.CREDIT_CARD); b3.setPaymentStatus(PaymentStatus.PENDING);
//        Booking b4 = new Booking(); b4.setJob(j4); b4.setBookingDateTime(LocalDateTime.now()); b4.setTotalFare(1500.0); b4.setPaymentMethod(PaymentMethod.DEBIT_CARD); b4.setPaymentStatus(PaymentStatus.SUCCESS);
//        Booking b5 = new Booking(); b5.setJob(j5); b5.setBookingDateTime(LocalDateTime.now()); b5.setTotalFare(2000.0); b5.setPaymentMethod(PaymentMethod.BANK_TRANSFER); b5.setPaymentStatus(PaymentStatus.FAILED);
//        bookingService.save(b1);
//        bookingService.save(b2);
//        bookingService.save(b3);
//        bookingService.save(b4);
//        bookingService.save(b5);
//
//        // --- PAYMENTS ---
//        Payment p1 = new Payment(); p1.setPayer(u1); p1.setBooking(b1); p1.setAmount(500.0); p1.setPaymentMethod(PaymentMethod.CASH); p1.setPaymentStatus(PaymentStatus.SUCCESS);
//        Payment p2 = new Payment(); p2.setPayer(u2); p2.setBooking(b2); p2.setAmount(800.0); p2.setPaymentMethod(PaymentMethod.UPI); p2.setPaymentStatus(PaymentStatus.SUCCESS);
//        Payment p3 = new Payment(); p3.setPayer(u3); p3.setBooking(b3); p3.setAmount(1200.0); p3.setPaymentMethod(PaymentMethod.CREDIT_CARD); p3.setPaymentStatus(PaymentStatus.PENDING);
//        Payment p4 = new Payment(); p4.setPayer(u4); p4.setBooking(b4); p4.setAmount(1500.0); p4.setPaymentMethod(PaymentMethod.DEBIT_CARD); p4.setPaymentStatus(PaymentStatus.SUCCESS);
//        Payment p5 = new Payment(); p5.setPayer(u5); p5.setBooking(b5); p5.setAmount(2000.0); p5.setPaymentMethod(PaymentMethod.BANK_TRANSFER); p5.setPaymentStatus(PaymentStatus.FAILED);
//        paymentService.save(p1);
//        paymentService.save(p2);
//        paymentService.save(p3);
//        paymentService.save(p4);
//        paymentService.save(p5);
//
//        // --- REVIEWS ---
//        Review r1 = new Review(); r1.setReviewer(u1); r1.setHandyman(h1); r1.setRating(5); r1.setComments("Great work!");
//        Review r2 = new Review(); r2.setReviewer(u2); r2.setHandyman(h2); r2.setRating(4); r2.setComments("Good plumber.");
//        Review r3 = new Review(); r3.setReviewer(u3); r3.setHandyman(h3); r3.setRating(5); r3.setComments("Excellent carpenter!");
//        Review r4 = new Review(); r4.setReviewer(u4); r4.setHandyman(h4); r4.setRating(3); r4.setComments("Average painting.");
//        Review r5 = new Review(); r5.setReviewer(u5); r5.setHandyman(h5); r5.setRating(4); r5.setComments("AC fixed well.");
//        reviewService.save(r1);
//        reviewService.save(r2);
//        reviewService.save(r3);
//        reviewService.save(r4);
//        reviewService.save(r5);
//
//        // --- NOTIFICATIONS ---
//        Notification n1 = new Notification(); n1.setRecipient(u1); n1.setMessage("Your booking is confirmed."); n1.setType("EMAIL");
//        Notification n2 = new Notification(); n2.setRecipient(u2); n2.setMessage("Your payment is successful."); n2.setType("SMS");
//        Notification n3 = new Notification(); n3.setRecipient(u3); n3.setMessage("Handyman has arrived."); n3.setType("PUSH");
//        Notification n4 = new Notification(); n4.setRecipient(u4); n4.setMessage("Job completed!"); n4.setType("IN_APP");
//        Notification n5 = new Notification(); n5.setRecipient(u5); n5.setMessage("Payment failed."); n5.setType("EMAIL");
//        notificationService.save(n1);
//        notificationService.save(n2);
//        notificationService.save(n3);
//        notificationService.save(n4);
//        notificationService.save(n5);
//
//        // --- SUPPORT TICKETS ---
//        SupportTicket t1 = new SupportTicket(); t1.setUser(u1); t1.setSubject("Refund Issue"); t1.setDescription("Refund not received");
//        SupportTicket t2 = new SupportTicket(); t2.setUser(u2); t2.setSubject("Late Arrival"); t2.setDescription("Handyman arrived late");
//        SupportTicket t3 = new SupportTicket(); t3.setUser(u3); t3.setSubject("Overcharging"); t3.setDescription("Charged more than quoted");
//        SupportTicket t4 = new SupportTicket(); t4.setUser(u4); t4.setSubject("App Bug"); t4.setDescription("App keeps crashing");
//        SupportTicket t5 = new SupportTicket(); t5.setUser(u5); t5.setSubject("Payment Failed"); t5.setDescription("UPI transaction failed");
//        supportTicketService.save(t1);
//        supportTicketService.save(t2);
//        supportTicketService.save(t3);
//        supportTicketService.save(t4);
//        supportTicketService.save(t5);
//        
        
        System.out.println("✅ Dummy data inserted successfully!");
    }
}

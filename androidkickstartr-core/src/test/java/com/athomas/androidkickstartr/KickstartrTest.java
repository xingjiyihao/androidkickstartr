package com.athomas.androidkickstartr;

import java.io.File;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.athomas.androidkickstartr.model.Application;
import com.athomas.androidkickstartr.model.State;

public class KickstartrTest {

	private static Application application;

	private Kickstartr kickstartr;
	private State state;

	@Before
	public void tearUp() {
		application = new Application.Builder().//
				packageName("com.androidkickstartr.app").//
				name("MyApp").//
				activity("MainActivity").//
				activityLayout("main_activity").//
				minSdk(8).//
				targetSdk(16).//
				permissions(new ArrayList<String>()).//
				build();
	}

	@After
	public void cleanProject() {
		kickstartr.clean();
	}

	/*
	 * MAVEN
	 */

	@Test
	public void generateProject_maven_abs() {
		state = new State.Builder().//
				maven(true). //
				actionBarSherlock(true).//
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}
	
	@Test
	public void generateProject_maven_abs_tab() {
		state = new State.Builder().//
				maven(true). //
				actionBarSherlock(true).//
				tabNavigation(true). //
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}
	
	@Test
	public void generateProject_maven_abs_list() {
		state = new State.Builder().//
				maven(true). //
				actionBarSherlock(true).//
				listNavigation(true). //
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}

	@Test
	public void generateProject_maven_aa() {
		state = new State.Builder().//
				maven(true). //
				androidAnnotations(true).//
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}

	@Test
	public void generateProject_maven_abs_aa() {
		state = new State.Builder().//
				maven(true). //
				androidAnnotations(true).//
				actionBarSherlock(true).//
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}

	@Test
	public void generateProject_maven_aa_rest() {
		state = new State.Builder().//
				maven(true). //
				androidAnnotations(true).//
				restTemplate(true).//
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}

	@Test
	public void generateProject_maven_aa_rest_acra() {
		state = new State.Builder().//
				maven(true). //
				androidAnnotations(true).//
				restTemplate(true).//
				acra(true). //
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}

	@Test
	public void generateProject_maven_abs_aa_rest_acra() {
		state = new State.Builder().//
				maven(true). //
				actionBarSherlock(true). //
				androidAnnotations(true). //
				restTemplate(true).//
				acra(true). //
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}

	@Test
	public void generateProject_maven_abs_aa_rest_acra_nine() {
		state = new State.Builder().//
				maven(true). //
				actionBarSherlock(true). //
				androidAnnotations(true). //
				restTemplate(true).//
				acra(true). //
				nineOldAndroids(true). //
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}

	/*
	 * NON-MAVEN
	 */

	@Test
	public void generateProject_abs() {
		state = new State.Builder().//
				actionBarSherlock(true).//
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}
	
	@Test
	public void generateProject_abs_tab() {
		state = new State.Builder().//
				actionBarSherlock(true).//
				tabNavigation(true). //
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}
	
	@Test
	public void generateProject_abs_list() {
		state = new State.Builder().//
				actionBarSherlock(true).//
				listNavigation(true). //
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}

	@Test
	public void generateProject_aa() {
		state = new State.Builder().//
				androidAnnotations(true).//
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}

	@Test
	public void generateProject_abs_aa() {
		state = new State.Builder().//
				androidAnnotations(true).//
				actionBarSherlock(true).//
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}

	@Test
	public void generateProject_aa_rest() {
		state = new State.Builder().//
				androidAnnotations(true).//
				restTemplate(true).//
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}

	@Test
	public void generateProject_aa_rest_acra() {
		state = new State.Builder().//
				androidAnnotations(true).//
				restTemplate(true).//
				acra(true). //
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}

	@Test
	public void generateProject_abs_aa_rest_acra() {
		state = new State.Builder().//
				actionBarSherlock(true). //
				androidAnnotations(true). //
				restTemplate(true).//
				acra(true). //
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}

	@Test
	public void generateProject_abs_aa_rest_acra_nine() {
		state = new State.Builder().//
				actionBarSherlock(true). //
				androidAnnotations(true). //
				restTemplate(true).//
				acra(true). //
				nineOldAndroids(true). //
				build();

		File file = launchKickstartr();
		Assert.assertNotNull(file);
	}
	
	private File launchKickstartr() {
		kickstartr = new Kickstartr(state, application);
		return kickstartr.start();
	}

}

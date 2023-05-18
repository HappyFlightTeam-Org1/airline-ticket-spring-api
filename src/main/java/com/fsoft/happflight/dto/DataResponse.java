package com.fsoft.happflight.dto;

import java.util.List;
import com.fsoft.happflight.entities.chuyen_bay.HangBay;
import com.fsoft.happflight.entities.chuyen_bay.MayBay;
import com.fsoft.happflight.entities.chuyen_bay.SanBay;

public class DataResponse {
	List<SanBay> sanBays;
	List<MayBay> mayBays;
	List<HangBay> hangBays;

	public DataResponse() {
		super();
	}

	public DataResponse(List<SanBay> sanBays, List<MayBay> mayBays, List<HangBay> hangBays) {
		super();
		this.sanBays = sanBays;
		this.mayBays = mayBays;
		this.hangBays = hangBays;
	}

	public List<SanBay> getSanBays() {
		return sanBays;
	}

	public void setSanBays(List<SanBay> sanBays) {
		this.sanBays = sanBays;
	}

	public List<MayBay> getMayBays() {
		return mayBays;
	}

	public void setMayBays(List<MayBay> mayBays) {
		this.mayBays = mayBays;
	}

	public List<HangBay> getHangBays() {
		return hangBays;
	}

	public void setHangBays(List<HangBay> hangBays) {
		this.hangBays = hangBays;
	}

}

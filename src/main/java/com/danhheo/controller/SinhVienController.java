package com.danhheo.controller;

import com.danhheo.model.Nganh;
import com.danhheo.model.SinhVien;
import com.danhheo.model.TotNghiep;
import com.danhheo.model.Truong;
import com.danhheo.service.NganhService;
import com.danhheo.service.SinhVienService;
import com.danhheo.service.TotNghiepService;
import com.danhheo.service.TruongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SinhVienController {

    private final SinhVienService sinhVienService;
    private final TotNghiepService totNghiepService;
    private final TruongService truongService;
    private final NganhService nganhService;

    @Autowired
    public SinhVienController(SinhVienService sinhVienService, TotNghiepService totNghiepService,
                              TruongService truongService, NganhService nganhService) {
        this.sinhVienService = sinhVienService;
        this.totNghiepService = totNghiepService;
        this.truongService = truongService;
        this.nganhService = nganhService;
    }

    @GetMapping("/input")
    public String showInputForm(Model model) throws Exception {
        model.addAttribute("sinhVien", new SinhVien());
        model.addAttribute("totNghiep", new TotNghiep());
        model.addAttribute("truongs", truongService.getAll());
        model.addAttribute("nganhs", nganhService.getAll());
        return "input";
    }

    @PostMapping("/input")
    public String submitInputForm(@ModelAttribute SinhVien sinhVien, @ModelAttribute TotNghiep totNghiep,
                                  @RequestParam("ngayTnStr") String ngayTnStr, Model model) {
        try {
            // Validate mandatory fields
            if (sinhVien.getSoCmnd() == null || sinhVien.getSoCmnd().trim().isEmpty() ||
                totNghiep.getMaTruong() == null || totNghiep.getMaTruong().trim().isEmpty() ||
                totNghiep.getMaNganh() == null || totNghiep.getMaNganh().trim().isEmpty()) {
                model.addAttribute("error", "Số CMND, Mã Trường, Mã Ngành là bắt buộc.");
                // Reload truongs and nghanhs
                model.addAttribute("truongs", truongService.getAll());
                model.addAttribute("nganhs", nganhService.getAll());
                return "input";
            }

            // Validate date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            Date ngayTn;
            try {
                ngayTn = sdf.parse(ngayTnStr);
                totNghiep.setNgayTn(ngayTn);
            } catch (Exception e) {
                model.addAttribute("error", "Ngày tốt nghiệp không hợp lệ (yyyy-MM-dd).");
                // Reload truongs and nghanhs
                model.addAttribute("truongs", truongService.getAll());
                model.addAttribute("nganhs", nganhService.getAll());
                return "input";
            }

            // Save data
            sinhVienService.save(sinhVien);
            totNghiep.setSoCmnd(sinhVien.getSoCmnd());
            totNghiepService.save(totNghiep);
            model.addAttribute("message", "Lưu thông tin thành công!");
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi lưu thông tin: " + e.getMessage());
        }

        // Reload truongs and nghanhs after processing
        try {
            model.addAttribute("truongs", truongService.getAll());
            model.addAttribute("nganhs", nganhService.getAll());
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi tải danh sách trường/ngành: " + e.getMessage());
        }
        return "input";
    }

    @GetMapping("/search")
    public String showSearchForm() {
        return "search";
    }

    @PostMapping("/search")
    public String searchSinhVien(@RequestParam("keyword") String keyword, Model model) {
        try {
            List<SinhVien> sinhViens = sinhVienService.search(keyword);
            model.addAttribute("sinhViens", sinhViens);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi tìm kiếm: " + e.getMessage());
        }
        return "search";
    }

    @GetMapping("/search-employment")
    public String showSearchEmploymentForm() {
        return "search_employment";
    }

    @PostMapping("/search-employment")
    public String searchEmployment(@RequestParam("keyword") String keyword, Model model) {
        try {
            List<Object[]> results = totNghiepService.searchEmployment(keyword);
            model.addAttribute("results", results);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi tìm kiếm: " + e.getMessage());
        }
        return "search_employment";
    }
}

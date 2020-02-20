# Makefile for Tango server and resource files

TOP = $(CURDIR)/..

include $(TOP)/CONFIG

TMBF_RES =
TMBF_RES += e2t_tmbf_global.res
TMBF_RES += e2t_tmbf_horizontal.res
TMBF_RES += e2t_tmbf_vertical.res

TFIT_RES =
TFIT_RES += e2t_tfit_horizontal.res
TFIT_RES += e2t_tfit_vertical.res

LMBF_RES = 
LMBF_RES += e2t_lmbf_longitudinal.res

default: $(TMBF_RES) $(TFIT_RES) $(LMBF_RES) mbfstartioc-res macroserver-res mbfcontrol-res
.PHONY: default

$(TMBF_RES): %.res: $(DB_FILES_DIR)/tmbf.db
	tools/T2E_make_res.py tmbf $(DB_FILES_DIR)/tmbf.db $(subst e2t_tmbf_,,$*) > $(RESOURCE_DIR)/$*.res

$(TFIT_RES): %.res: $(DB_FILES_DIR)/tune_fit.db
	tools/T2E_make_res.py tfit $(DB_FILES_DIR)/tune_fit.db $(subst e2t_tfit_,,$*) > $(RESOURCE_DIR)/$*.res

$(LMBF_RES): %.res: $(DB_FILES_DIR)/lmbf.db
	tools/T2E_make_lmbf_res.py lmbf $(DB_FILES_DIR)/lmbf.db $(subst e2t_lmbf_,,$*) > $(RESOURCE_DIR)/$*.res

mbfstartioc-res:
	make -C servers/MBFStartIOC -f ../Makefile-res TOP=$(TOP)
.PHONY: mbfstartioc-res

mbfstartioc-res-clean:
	make -C servers/MBFStartIOC -f ../Makefile-res TOP=$(TOP) clean
.PHONY: mbfstartioc-res-clean

macroserver-res:
	make -C servers/MacroServer -f ../Makefile-res TOP=$(TOP)
.PHONY: macroserver-res

macroserver-res-clean:
	make -C servers/MacroServer -f ../Makefile-res TOP=$(TOP) clean
.PHONY: macroserver-res-clean

mbfcontrol-res:
	make -C servers/MBFControl -f ../Makefile-res TOP=$(TOP)
.PHONY: mbfcontrol-res

mbfcontrol-res-clean:
	make -C servers/MBFControl -f ../Makefile-res TOP=$(TOP) clean
.PHONY: mbfcontrol-res-clean

clean: mbfstartioc-res-clean macroserver-res-clean mbfcontrol-res-clean
	rm -f tools/*.pyc
	rm -f $(RESOURCE_DIR)/*.res
.PHONY: clean

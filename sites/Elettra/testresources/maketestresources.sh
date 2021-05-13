#!/bin/bash
echo 'genenrating Elettra Tango2Epics test configuration resources for MBF TEST'
rm -f ./*res
cp -n ../resources/*.res .
sed -i 's/tmbf/t-tmbf/g' e2t_tmbf_*.res
sed -i 's/tmbf/t-tmbf/g' e2t_tfit_*.res
sed -i 's/lmbf/t-lmbf/g' e2t_lmbf_longitudinal.res
sed -i 's/SR-/T-/g' *.res

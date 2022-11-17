package uz.nurlibaydev.ecommerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import uz.nurlibaydev.ecommerce.databinding.FragmentBottomFilterSheetBinding
import uz.nurlibaydev.ecommerce.utils.BrandsList
import uz.nurlibaydev.ecommerce.utils.PriceList
import uz.nurlibaydev.ecommerce.utils.SizeList
import uz.nurlibaydev.ecommerce.utils.extenions.onClick

class BottomFilterSheet : BottomSheetDialogFragment() {

    private val binding: FragmentBottomFilterSheetBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_bottom_filter_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            setData()
            btnClose.onClick {
                requireDialog().dismiss()
            }
            btnDone.onClick {
                requireDialog().dismiss()
            }
        }
    }

    private fun FragmentBottomFilterSheetBinding.setData() {
        val brandsList = BrandsList.list
        val adapter = ArrayAdapter(requireContext(), R.layout.filter_list_item, brandsList)
        actvBrand.setAdapter(adapter)

        val priceList = PriceList.list
        val priceAdapter = ArrayAdapter(requireContext(), R.layout.filter_list_item, priceList)
        actvPrice.setAdapter(priceAdapter)

        val sizeList = SizeList.list
        val sizeAdapter = ArrayAdapter(requireContext(), R.layout.filter_list_item, sizeList)
        actvSize.setAdapter(sizeAdapter)
    }
}
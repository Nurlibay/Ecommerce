package uz.nurlibaydev.ecommerce

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import uz.nurlibaydev.ecommerce.databinding.FragmentBottomFilterSheetBinding
import uz.nurlibaydev.ecommerce.presentation.main.explorer.ExplorerScreen
import uz.nurlibaydev.ecommerce.utils.BrandsList
import uz.nurlibaydev.ecommerce.utils.PriceList
import uz.nurlibaydev.ecommerce.utils.SizeList


class BottomFilterSheet(private val fragment: ExplorerScreen) : BottomSheetDialogFragment() {


    private var _binding: FragmentBottomFilterSheetBinding? = null
    private val binding: FragmentBottomFilterSheetBinding
        get() = _binding ?: throw RuntimeException("FragmentBottomFilterSheetBinding == null")

    init {
        show(fragment.requireActivity().supportFragmentManager, "tag")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomFilterSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val brandsList = BrandsList.list
        val brandAdapter = ArrayAdapter(requireContext(), R.layout.filter_list_item, brandsList)
        binding.brandSpinner.adapter = brandAdapter

        val priceList = PriceList.list
        val priceAdapter = ArrayAdapter(requireContext(), R.layout.filter_list_item, priceList)
        binding.priceSpinner.adapter = priceAdapter

        val sizeList = SizeList.list
        val sizeAdapter = ArrayAdapter(requireContext(), R.layout.filter_list_item, sizeList)
        binding.sizeSpinner.adapter = sizeAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}